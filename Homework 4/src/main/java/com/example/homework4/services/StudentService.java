package com.example.homework4.services;

import com.example.homework4.models.Student;
import com.example.homework4.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    final StudentRepository sr;

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Iterable<Student> studentIterable = sr.findAll();
        studentIterable.iterator().forEachRemaining(students::add);
        return students;
    }

    @Transactional
    public Student save(Student student) {
        return sr.save(student);
    }

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return sr.findById(id).get();
    }

    @Transactional
    public Student update(Student student) {
        return sr.save(student);
    }

    @Transactional
    public void deleteById(Long id) {
        sr.deleteById(id);
    }
}
