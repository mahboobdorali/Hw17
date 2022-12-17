package ir.maktab.service;

import ir.maktab.entity.Course;
import ir.maktab.entity.Student;
import ir.maktab.entity.StudentCourseRating;

public interface StudentCourseRatingService {
    void saveStudentCourse(Student student, Course course);

    StudentCourseRating load(int lineNumber);

}
