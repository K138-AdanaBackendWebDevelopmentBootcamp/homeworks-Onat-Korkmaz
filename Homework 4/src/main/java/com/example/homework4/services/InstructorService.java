package com.example.homework4.services;

import com.example.homework4.models.Instructor;
import com.example.homework4.models.PermanentInstructor;
import com.example.homework4.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    final InstructorRepository ir;

    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> instructors = new ArrayList<>();
        Iterable<Instructor> instructorIterable = ir.findAll();
        instructorIterable.iterator().forEachRemaining(instructors::add);
        return instructors;
    }

    @Transactional
    public Instructor save(Instructor instructor) {
        return ir.save(instructor);
    }

    @Transactional(readOnly = true)
    public Instructor findById(Long id) {
        return ir.findById(id).get();
    }

    @Transactional
    public Instructor update(Instructor instructor) {
        return ir.save(instructor);
    }

    @Transactional
    public void deleteById(Long id) {
        ir.deleteById(id);
    }

    @Transactional
    public Instructor findByName(String name) {
        return ir.findByName(name);
    }

    @Transactional
    public void deleteByName(String name) {
        ir.deleteInstructorByName(name);
    }

    public List<Instructor> topThreeSalaryInstructor(){
        Iterable<Instructor> instructors = ir.findTop3ByOrderBySalaryDesc();
        List<Instructor> topThree = new ArrayList<>();
        instructors.forEach(topThree::add);
        return topThree;
    }
}
