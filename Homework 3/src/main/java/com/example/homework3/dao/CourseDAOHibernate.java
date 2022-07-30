package com.example.homework3.dao;

import com.example.homework3.models.Course;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernate implements ICourseDAO<Course> {

    EntityManager em;

    public CourseDAOHibernate(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Course> findAll() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findByID(Long id) {
        return null;
    }

    @Override
    public Course save(Course object) {
        return null;
    }

    @Override
    public void deleteByID(Long id) {

    }

    @Override
    public Course update(Course object) {
        return null;
    }
}
