package com.example.graduationproject.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int code;
    private int creditScore;

    @JsonBackReference
    @ManyToMany// https://www.baeldung.com/hibernate-many-to-many
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Student> students;


    @JsonBackReference
    @ManyToOne
    private Instructor instructor;
}
