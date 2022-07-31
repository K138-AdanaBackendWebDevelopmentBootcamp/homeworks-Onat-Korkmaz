package com.example.graduationproject.repositories;

import com.example.graduationproject.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findByName(String name);
    Iterable<Instructor> findTop3ByOrderBySalaryDesc();

     void deleteInstructorByName(String name);
}
