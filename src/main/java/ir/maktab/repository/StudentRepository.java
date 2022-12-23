package ir.maktab.repository;

import ir.maktab.configuration.Config;
import ir.maktab.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentRepository {
    private static StudentRepository instance = new StudentRepository();

    private StudentRepository() {

    }

    public static StudentRepository getInstance() {
        return instance;
    }

    public void persist(Student student) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Student findByName(String studentName) {
        EntityManager entityManager = Config.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Student s where s.studentName =:studentName");
        query.setParameter("studentName", studentName);
        Student singleResult = (Student) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }
}
