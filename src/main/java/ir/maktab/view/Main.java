package ir.maktab.view;

import ir.maktab.entity.StudentCourseRating;
import ir.maktab.service.serviceImpl.StudentCourseRatingImpl;

public class Main {
    public static void main(String[] args) {
        StudentCourseRatingImpl studentCourseRating=StudentCourseRatingImpl.getInstance();
        StudentCourseRating load = studentCourseRating.load();
        System.out.println(load);
    }
}
