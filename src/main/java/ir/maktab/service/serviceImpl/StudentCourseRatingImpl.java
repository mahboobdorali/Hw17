package ir.maktab.service.serviceImpl;

import ir.maktab.entity.Course;
import ir.maktab.entity.Student;
import ir.maktab.entity.StudentCourseRating;
import ir.maktab.repository.StudentCourseRatingRepository;
import ir.maktab.service.StudentCourseRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentCourseRatingImpl implements StudentCourseRatingService {
    private static CourseImpl courseImpl=CourseImpl.getInstance();
    private static StudentImpl studentImpl=StudentImpl.getInstance();
    private static StudentCourseRatingImpl instance = new StudentCourseRatingImpl();

    private StudentCourseRatingImpl() {

    }
    public static StudentCourseRatingImpl getInstance() {
        return instance;
    }

    private Logger logger = LoggerFactory.getLogger(StudentCourseRatingImpl.class);
    StudentCourseRatingRepository studentCourseRatingRepository =
            StudentCourseRatingRepository.getInstance();


    @Override
    public StudentCourseRating load() {
        try (RandomAccessFile file = new RandomAccessFile("D:\\java\\log_io\\Homework17\\src\\main\\java\\ir\\maktab\\File.txt", "rw")) {
            String readLine = null;
            for (int i = 1; i <= 5; i++) {
                readLine = file.readLine();

                String[] studentInfo = readLine.split(",");
                StudentCourseRating studentCourseRating = new StudentCourseRating();
                Course course = new Course();
                Student student = new Student();

                course.setCourseName(studentInfo[0]);
                student.setStudentName(studentInfo[1]);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = formatter.parse(studentInfo[2]);
                studentCourseRating.setTimeStamp(date);
                studentCourseRating.setRating(Double.parseDouble(studentInfo[3]));
                studentCourseRating.setComment(studentInfo[4]);
                logger.info("studentCourse loaded");

                courseImpl.saveCourse(course);
                studentImpl.saveStudent(student);

                studentCourseRating.setCourse(course);
                studentCourseRating.setStudent(student);
                studentCourseRatingRepository.persist(studentCourseRating);
                return studentCourseRating;
            }
        } catch (FileNotFoundException e) {
            logger.error("file not found ):");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("sorry");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            logger.error("your date not valid");
            throw new RuntimeException(e);
        }
        return null;
    }
}
