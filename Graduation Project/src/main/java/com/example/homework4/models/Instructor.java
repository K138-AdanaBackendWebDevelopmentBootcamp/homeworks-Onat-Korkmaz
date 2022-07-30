package com.example.homework4.models;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "instructor")
    private List<Course> courses;
    @Setter(AccessLevel.PROTECTED) //direkt olarak salary'i değiştirmelerini istemiyoruz, o yüzden sadece alt sınıflarda görünür olmalı.
    private double salary; // buraya state ekledim ki ücretlendirmede sıralama yaptırmamız için verimiz olsun
}
