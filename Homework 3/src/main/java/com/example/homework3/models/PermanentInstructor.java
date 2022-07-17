package com.example.homework3.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class PermanentInstructor extends Instructor {
    private double hourlySalary;

    public PermanentInstructor(String name, String address, String phoneNo, List<Course> courses, double hourlySalary) {
        super(name, address, phoneNo, courses);
        this.hourlySalary = hourlySalary;
    }

    public PermanentInstructor() {
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
