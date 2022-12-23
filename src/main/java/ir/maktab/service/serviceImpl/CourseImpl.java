package ir.maktab.service.serviceImpl;

import ir.maktab.entity.Course;
import ir.maktab.repository.CourseRepository;
import ir.maktab.service.CourseService;

public class CourseImpl implements CourseService {
    private static CourseImpl instance = new CourseImpl();

    private CourseImpl() {

    }

    public static CourseImpl getInstance() {
        return instance;
    }
    CourseRepository courseRepository=CourseRepository.getInstance();
    @Override
    public void saveCourse(Course course) {
        courseRepository.persist(course);
    }
}
