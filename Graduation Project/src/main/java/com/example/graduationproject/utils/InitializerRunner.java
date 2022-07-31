package com.example.graduationproject.utils;

import com.example.graduationproject.models.*;
import com.example.graduationproject.repositories.CourseRepository;
import com.example.graduationproject.repositories.InstructorRepository;
import com.example.graduationproject.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        courseRepository.deleteAll();
        instructorRepository.deleteAll();
        studentRepository.deleteAll();

        Course course1 = new Course();
        course1.setName("MATH");
        course1.setCode(101);
        course1.setCreditScore(8);

        Course course2 = new Course();
        course2.setName("CS");
        course2.setCode(443);
        course2.setCreditScore(7);

        Course course3 = new Course();
        course3.setName("PHYS");
        course3.setCode(102);
        course3.setCreditScore(9);

        VisitingInstructor instructor1 = new VisitingInstructor();
        instructor1.setName("Oktay Sinanoğlu");
        instructor1.setAddress("İstanbul");
        instructor1.setHourlySalary(30);
        instructor1.setPhoneNo("5051234567");

        PermanentInstructor instructor2 = new PermanentInstructor();
        instructor2.setName("David Davenport");
        instructor2.setAddress("Ankara");
        instructor2.setFixedSalary(25);
        instructor2.setPhoneNo("5351234567");

        PermanentInstructor instructor3 = new PermanentInstructor();
        instructor3.setName("Albert Einstein");
        instructor3.setAddress("Munich");
        instructor3.setFixedSalary(40);
        instructor3.setPhoneNo("9786452123");

        Student student1 = new Student();
        student1.setName("Onat Korkmaz");
        student1.setAddress("Bilkent");
        student1.setBirthDate(LocalDate.of(2000,1,1));
        student1.setGender("Male");

        Student student2 = new Student();
        student2.setName("Üryan Mert Meriç");
        student2.setAddress("Bilkent");
        student2.setBirthDate(LocalDate.of(1998,12,21));
        student2.setGender("Male");

        Student student3 = new Student();
        student3.setName("Nilsu Ürkmez");
        student3.setAddress("Bahçelievler");
        student3.setBirthDate(LocalDate.of(2000,3,28));
        student3.setGender("Female");

        Student student4 = new Student();
        student4.setName("Helin Bilen");
        student4.setAddress("Emek");
        student4.setBirthDate(LocalDate.of(2000,4,14));
        student4.setGender("Female");

        Student student5 = new Student();
        student5.setName("Ecem Kişin");
        student5.setAddress("Emek");
        student5.setBirthDate(LocalDate.of(2000,5,2));
        student5.setGender("Female");

        Student student6 = new Student();
        student6.setName("Soner Doruk Canpolat");
        student6.setAddress("Etlik");
        student6.setBirthDate(LocalDate.of(2000,11,16));
        student6.setGender("Male");

        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList2 = new ArrayList<>();
        List<Course> courseList3 = new ArrayList<>();
        List<Course> courseList4 = new ArrayList<>();
        List<Course> courseList5 = new ArrayList<>();
        List<Course> courseList6 = new ArrayList<>();
        List<Course> courseList7 = new ArrayList<>();
        List<Course> courseList8 = new ArrayList<>();
        List<Course> courseList9 = new ArrayList<>();

        List<Student> studentList1 = new ArrayList<>();
        List<Student> studentList2 = new ArrayList<>();
        List<Student> studentList3 = new ArrayList<>();

        courseList1.add(course1);
        courseList2.add(course2);
        courseList3.add(course3);
        courseList4.add(course1);
        courseList5.add(course1);
        courseList6.add(course2);
        courseList7.add(course2);
        courseList8.add(course3);
        courseList9.add(course3);

        studentList1.add(student1);
        studentList1.add(student2);
        studentList2.add(student3);
        studentList2.add(student4);
        studentList3.add(student5);
        studentList3.add(student6);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);
        course1.setStudents(studentList1);
        course2.setStudents(studentList2);
        course3.setStudents(studentList3);
        instructor1.setCourses(courseList1);
        instructor2.setCourses(courseList2);
        instructor3.setCourses(courseList3);
        student1.setCourseList(courseList4);
        student2.setCourseList(courseList5);
        student3.setCourseList(courseList6);
        student4.setCourseList(courseList7);
        student5.setCourseList(courseList8);
        student6.setCourseList(courseList9);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);

    }
}
