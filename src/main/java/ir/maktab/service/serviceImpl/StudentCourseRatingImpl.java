package ir.maktab.service.serviceImpl;

import ir.maktab.entity.Course;
import ir.maktab.entity.Student;
import ir.maktab.entity.StudentCourseRating;
import ir.maktab.repository.StudentCourseRatingRepository;
import ir.maktab.service.StudentCourseRatingService;

public class StudentCourseRatingImpl implements StudentCourseRatingService {
    StudentCourseRatingRepository studentCourseRatingRepository=
            StudentCourseRatingRepository.getInstance();
    @Override
    public void saveStudentCourse(Student student, Course course) {
        StudentCourseRating studentCourseRating=new StudentCourseRating();
        studentCourseRating.setCourse(course);
        studentCourseRating.setStudent(student);
        studentCourseRatingRepository.persist(studentCourseRating);
    }
}
