package ir.maktab.repository;

import ir.maktab.configuration.Config;
import ir.maktab.entity.StudentCourseRating;

import javax.persistence.EntityManager;

public class StudentCourseRatingRepository {
    private static StudentCourseRatingRepository instance = new StudentCourseRatingRepository();

    private StudentCourseRatingRepository() {

    }

    public static StudentCourseRatingRepository getInstance() {
        return instance;
    }

    public void persist(StudentCourseRating studentCourseRating){
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(studentCourseRating);
        em.getTransaction().commit();
        em.close();
    }
}
