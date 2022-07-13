package controllers;

import models.Course;
import models.Instructor;
import models.Student;
import services.CourseService;

import java.util.List;

public class CourseController {
    CourseService courseService = new CourseService();

    public List<Course> listAllCourses() {
        return courseService.findAll();
    }

    public Course findByID(int id) {
        return courseService.findByID(id);
    }

    public void saveCourse(Course course) {
        courseService.saveToDB(course);
    }

    public void deleteCourse(Course course) {
        courseService.deleteFromDB(course);
    }

    public void deleteCourse(int id) {
        courseService.deleteFromDB(id);
    }

    public void deleteCourseByID(int id) {
        courseService.deleteByID(id);
    }

    public void updateCourse(Course course, int id) {
        courseService.updateDB(course, id);
    }

    public Instructor getInstructor(Course course) {
        return courseService.getInstructor(course);
    }

    public List<Student> getStudentList(Course course) {
        return courseService.getStudentList(course);
    }
}
