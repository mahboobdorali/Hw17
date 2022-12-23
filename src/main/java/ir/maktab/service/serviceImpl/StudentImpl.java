package ir.maktab.service.serviceImpl;

import ir.maktab.entity.Student;
import ir.maktab.repository.StudentRepository;
import ir.maktab.service.StudentService;

public class StudentImpl implements StudentService {
    private static StudentImpl instance = new StudentImpl();

    private StudentImpl() {

    }

    public static StudentImpl getInstance() {
        return instance;
    }
    StudentRepository studentRepository=StudentRepository.getInstance();
    @Override
    public void saveStudent(Student student) {
        studentRepository.persist(student);
    }
}
