package com.example.homework4.controllers;

import com.example.homework4.models.Instructor;
import com.example.homework4.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService is;

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<>(is.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public Instructor getinstructorById(@PathVariable Long id) {
        return is.findById(id);
    }

    @PostMapping("/instructors")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(is.save(instructor),HttpStatus.OK);
    }

    @PutMapping("/instructors")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(is.update(instructor),HttpStatus.OK);
    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable Long id) {
        is.deleteById(id);
        return "Deleted...";
    }
}
