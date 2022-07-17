package com.example.homework3.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(generator = "student", strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String address;
    private String gender;

    @ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courseList;

    public Student(String name, LocalDate birthDate, String address, String gender, List<Course> courseList) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.courseList = courseList;
    }

    public Student() {
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
