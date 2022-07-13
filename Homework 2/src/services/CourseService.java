package services;

import models.Course;
import models.Instructor;
import models.Student;
import repositories.CRUDRepository;
import repositories.CourseRepository;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CRUDRepository<Course>, CourseRepository {
    EntityManager em = HibernateUtil.buildSF();

    @Override
    public List<Course> findAll() {
        em.getTransaction().begin();
        List<Course> courseList = em.createQuery("from Course",Course.class).getResultList();
        return courseList;
    }

    @Override
    public Course findByID(int id) {
        em.getTransaction().begin();
        Course course = em.find(Course.class,id);
        return course;
    }

    @Override
    public void saveToDB(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }finally {

        }
    }

    @Override
    public void deleteFromDB(Course course) {
        try {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDB(int id) {
        try {
            em.getTransaction().begin();
            Course course = findByID(id);
            em.remove(course);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void updateDB(Course course, int id) {
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    @Override
    public Instructor getInstructor(Course course) {
        try {
            em.getTransaction().begin();
            Course theCourse = em.find(Course.class,course.getId());
            return theCourse.getInstructor();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List<Student> getStudentList(Course course) {
        try {
            em.getTransaction().begin();
            Course theCourse = em.find(Course.class,course.getId());
            return theCourse.getStudents();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public void deleteByID(int id) {
        try {
            em.getTransaction().begin();
            Course course = em.createQuery("from Course where id =: id",Course.class).setParameter("id",id).getSingleResult();
            em.remove(course);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
    }
}
