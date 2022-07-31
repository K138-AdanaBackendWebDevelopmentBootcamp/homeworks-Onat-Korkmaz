package com.example.graduationproject.repositories;

import com.example.graduationproject.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByName(String name);
    int deleteByName(String name);
}
