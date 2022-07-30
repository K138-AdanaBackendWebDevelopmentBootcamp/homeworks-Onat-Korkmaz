package com.example.homework4.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    private double hourlySalary;
}
