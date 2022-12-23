package ir.maktab.repository;

import ir.maktab.configuration.Config;
import ir.maktab.entity.Course;
import ir.maktab.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CourseRepository {
    private static CourseRepository instance = new CourseRepository();

    private CourseRepository() {

    }

    public static CourseRepository getInstance() {
        return instance;
    }

    public void persist(Course course) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Course findCourseByName(String courseName) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Course c where c.courseName=:courseName");
        query.setParameter("courseName", courseName);
        Course singleResult = (Course) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }
}