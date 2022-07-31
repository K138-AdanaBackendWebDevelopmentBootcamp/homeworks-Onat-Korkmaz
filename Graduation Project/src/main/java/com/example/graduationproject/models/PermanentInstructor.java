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
public class PermanentInstructor extends Instructor {
    private double fixedSalary;

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        setSalary(fixedSalary);
    }
}
