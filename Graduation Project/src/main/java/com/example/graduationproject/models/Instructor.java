package com.example.graduationproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNo;

    @OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)
    private List<Course> courses;
    @Setter(AccessLevel.PROTECTED)
    private double salary;

}
