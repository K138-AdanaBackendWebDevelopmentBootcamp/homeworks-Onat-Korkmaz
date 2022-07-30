package com.example.homework4.controllers;

import com.example.homework4.models.Student;
import com.example.homework4.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService ss;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(ss.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return ss.findById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(ss.save(student),HttpStatus.OK);
    }

    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(ss.update(student),HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        ss.deleteById(id);
        return "Deleted...";
    }
}
