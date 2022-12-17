package ir.maktab.repository;

import ir.maktab.configuration.Config;
import ir.maktab.entity.Course;
import ir.maktab.entity.Student;

import javax.persistence.EntityManager;

public class CourseRepository {
    private static CourseRepository instance = new CourseRepository();

    private CourseRepository() {

    }

    public static CourseRepository getInstance() {
        return instance;
    }

    public void persist(Course course){
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
