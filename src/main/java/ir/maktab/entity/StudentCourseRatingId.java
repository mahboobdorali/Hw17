package ir.maktab.entity;
import lombok.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentCourseRatingId implements Serializable {
    private Student student;
    private Course course;
}
