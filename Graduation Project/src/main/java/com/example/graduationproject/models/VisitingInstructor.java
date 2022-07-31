package com.example.graduationproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class VisitingInstructor extends Instructor {
    private double hourlySalary;

    private static final int HOUR_MULTIPLY_MONTH = 8 * 30;
    public VisitingInstructor(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        setSalary(hourlySalary* HOUR_MULTIPLY_MONTH);
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        setSalary(hourlySalary*HOUR_MULTIPLY_MONTH);
    }
}
