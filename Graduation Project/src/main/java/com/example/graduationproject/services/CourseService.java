package com.example.graduationproject.services;

import com.example.graduationproject.models.Course;
import com.example.graduationproject.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    final CourseRepository cr;

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable = cr.findAll();
        courseIterable.iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Transactional
    public Course save(Course course) {
        return cr.save(course);
    }

    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return cr.findById(id).get();
    }

    @Transactional
    public Course update(Course course) {
        return cr.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        cr.deleteById(id);
    }

    @Transactional
    public Course findByName(String name) {
        return cr.findByName(name);
    }

    @Transactional
    public void deleteByName(String name) {
        cr.deleteByName(name);
    }
}
