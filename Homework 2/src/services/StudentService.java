package services;

import models.Course;
import models.Student;
import repositories.CRUDRepository;
import repositories.StudentRepository;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CRUDRepository<Student>, StudentRepository {
    EntityManager em = HibernateUtil.buildSF();

    @Override
    public List<Student> findAll() {
        em.getTransaction().begin();
        List<Student> studentList = em.createQuery("from Student",Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findByID(int id) {
        em.getTransaction().begin();
        Student student = em.find(Student.class,id);
        return student;
    }

    @Override
    public void saveToDB(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDB(Student student) {
        try {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDB(int id) {
        try {
            em.getTransaction().begin();
            Student student = findByID(id);
            em.remove(student);
            em.getTransaction().commit();
        }catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void updateDB(Student student, int id) {
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Course> getCourseList(Student student) {
        try {
            em.getTransaction().begin();
            Student theStudent = em.find(Student.class,student.getId());
            return theStudent.getCourseList();
        }catch (Exception e) {
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }
}
