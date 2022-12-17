package ir.maktab.service.serviceImpl;

import ir.maktab.entity.Student;
import ir.maktab.repository.StudentRepository;
import ir.maktab.service.StudentService;

public class studentImpl implements StudentService {
    StudentRepository studentRepository=StudentRepository.getInstance();
    @Override
    public void saveStudent(Student student) {
        studentRepository.persist(student);
    }
}
