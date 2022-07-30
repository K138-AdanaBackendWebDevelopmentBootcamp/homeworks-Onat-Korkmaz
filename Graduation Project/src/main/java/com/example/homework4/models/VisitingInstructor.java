package com.example.homework4.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class VisitingInstructor extends Instructor {
    private double fixedSalary;
}
