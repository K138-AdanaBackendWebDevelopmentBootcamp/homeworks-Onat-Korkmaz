package com.example.homework4.repositories;

import com.example.homework4.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query("from Course WHERE name =: name")
    Course findByName(String name);
}
