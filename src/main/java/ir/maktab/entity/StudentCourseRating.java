package ir.maktab.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StudentCourseRatingId.class)
public class StudentCourseRating {
    @Id
    @ManyToOne
    private Student student;

    @Id
    @ManyToOne
    private Course course;
    @CreationTimestamp
    private Date timeStamp;
    private String comment;
    private int rating;

}
