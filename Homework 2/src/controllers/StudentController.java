package controllers;

import models.Course;
import models.Student;
import services.StudentService;

import java.util.List;

public class StudentController {
    StudentService studentService = new StudentService();

    public List<Student> listAllStudents() {
        return studentService.findAll();
    }

    public Student findByID(int id) {
        return studentService.findByID(id);
    }

    public void saveStudent(Student student) {
        studentService.saveToDB(student);
    }

    public void deleteStudent(Student student) {
        studentService.deleteFromDB(student);
    }

    public void deleteStudent(int id) {
        studentService.deleteFromDB(id);
    }

    public void updateStudent(Student student, int id) {
        studentService.updateDB(student,id);
    }

    public List<Course> getCourseList(Student student) {
        return studentService.getCourseList(student);
    }
}
