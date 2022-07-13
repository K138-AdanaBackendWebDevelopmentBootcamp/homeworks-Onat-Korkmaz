package repositories;

import models.Course;
import models.Instructor;

import java.util.List;

public interface InstructorRepository {
    List<Course> getCourseList(Instructor instructor);
}
