package com.example.homework4.controllers;

import com.example.homework4.models.Course;
import com.example.homework4.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("course") // RequestMapping kullanabilirsin belirli bir endpoint üstünde bir şeyler yazacaksan, diğer Controllerlara yazmaya üşendim notları aynı şeyler geçerli :D
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService; // hiçbir şeyi kısaltarak kullanma olduğu gibi kullan, ileride daha büyük projelerinde kafa karışıklığına yol açabilir
                                                // bu haliyle daha okunabilir olur başkaları da kodunu okuyacaktır benim gibi
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping("/name") // ekstradan name olarak belirtmeye gerek yok
    public ResponseEntity<Course> getCourseByName(@RequestParam String name) {
        Course course = courseService.findByName(name);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.update(course),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteCourseById(@PathVariable Long id) {
        courseService.deleteById(id);
        return "Deleted...";
    }

    @DeleteMapping("/name/{name}")
    public String deleteCourseByName(@PathVariable String name) {
        courseService.deleteByName(name);
        return "Deleted...";
    }
}
