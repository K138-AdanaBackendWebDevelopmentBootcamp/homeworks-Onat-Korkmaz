package com.example.homework3.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor {
    @Id
    @GeneratedValue(generator = "instructor", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor", sequenceName = "INSTRUCTOR_SEQ_ID")
    private int id;
    private String name;
    private String address;
    private String phoneNo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "instructor")
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Instructor(String name, String address, String phoneNo, List<Course> courses) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.courses = courses;
    }

    public Instructor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }
}
