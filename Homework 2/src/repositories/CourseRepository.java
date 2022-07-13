package repositories;

import models.Course;
import models.Instructor;
import models.Student;

import java.util.List;

public interface CourseRepository {
    Instructor getInstructor(Course course);
    List<Student> getStudentList(Course course);
    void deleteByID(int id);
}
