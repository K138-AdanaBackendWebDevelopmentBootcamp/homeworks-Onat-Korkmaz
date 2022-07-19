package com.example.homework3.services;

import com.example.homework3.DAO.ICourseDAO;
import com.example.homework3.models.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService<Course>{

    ICourseDAO cd;

    public CourseService(ICourseDAO cd) {
        this.cd = cd;
    }

    @Override
    public List<Course> findAll() {
        return cd.findAll();
    }

    @Override
    public Course findByID(int id) {
        return null;
    }

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public void deleteByID(int id) {

    }

    @Override
    public Course update(Course course) {
        return null;
    }
}
