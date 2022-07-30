package com.example.homework3.dao;

import com.example.homework3.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAO implements ICourseDAO<Course> {

    EntityManager em;

    @Autowired
    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return em.createQuery("from Course",Course.class).getResultList();
    }

    @Override
    public Course findByID(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return em.merge(course);
    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public Course update(Course course) {
        return null;
    }
}
