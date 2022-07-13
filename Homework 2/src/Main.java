import controllers.CourseController;
import models.Course;
import models.PermanentInstructor;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Course c1 = new Course();
        Course c2 = new Course();

        c1.setCode(101);
        c1.setCreditScore(6);
        c1.setName("CS");

        c2.setCode(102);
        c2.setCreditScore(8);
        c2.setName("MATH");

        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        courseList.add(c1);
        courseList.add(c2);

        PermanentInstructor p1 = new PermanentInstructor();
        p1.setName("Koray Guney");
        p1.setAddress("address1");
        p1.setPhoneNo("12345679");
        p1.setHourlySalary(10000);
        p1.setCourses(courseList);

        c1.setInstructor(p1);
        c2.setInstructor(p1);

        CourseController cc = new CourseController();
        cc.saveCourse(c1);;
        cc.saveCourse(c2);
    }
}