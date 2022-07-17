package com.example.homework3.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(generator = "course", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course", sequenceName = "COURSE_SEQ_ID")
    private int id;
    private String name;
    private int code;
    private int creditScore;

    @ManyToMany
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Instructor instructor;

    public Course(String name, int code, int creditScore, List<Student> students, Instructor instructor) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
        this.students = students;
        this.instructor = instructor;
    }

    public Course() {
    }

    public Course(String name, int code, int creditScore) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }
}
