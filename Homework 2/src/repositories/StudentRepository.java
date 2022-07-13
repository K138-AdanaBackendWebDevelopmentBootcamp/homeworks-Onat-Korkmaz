package repositories;

import models.Course;
import models.Student;

import java.util.List;

public interface StudentRepository {
    List<Course> getCourseList(Student student);
}
