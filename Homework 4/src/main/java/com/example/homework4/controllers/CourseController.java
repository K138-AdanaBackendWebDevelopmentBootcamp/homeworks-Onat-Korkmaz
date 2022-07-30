package com.example.homework4.controllers;

import com.example.homework4.models.Course;
import com.example.homework4.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService cs;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/id/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return cs.findById(id);
    }

    @GetMapping("/courses/name")
    public ResponseEntity<Course> getCourseByName(@RequestParam String name) {
        Course course = cs.findByName(name);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(cs.save(course),HttpStatus.OK);
    }

    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return new ResponseEntity<>(cs.update(course),HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable Long id) {
        cs.deleteById(id);
        return "Deleted...";
    }
}
