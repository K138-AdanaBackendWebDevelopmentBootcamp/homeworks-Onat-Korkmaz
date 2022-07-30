package com.example.homework4.repositories;

import com.example.homework4.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findByName(String name);
    int deleteByName(String name);
}
