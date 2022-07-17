package com.example.homework3.controllers;

import com.example.homework3.models.Course;
import com.example.homework3.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    ICourseService cs;

    @Autowired
    public CourseController(ICourseService cs) {
        this.cs = cs;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);
    }
}
