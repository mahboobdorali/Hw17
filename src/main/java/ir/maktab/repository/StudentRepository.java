package ir.maktab.repository;

import ir.maktab.configuration.Config;
import ir.maktab.entity.Student;

import javax.persistence.EntityManager;

public class StudentRepository {
    private static StudentRepository instance = new StudentRepository();

    private StudentRepository() {

    }

    public static StudentRepository getInstance() {
        return instance;
    }

    public void persist(Student student){
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
