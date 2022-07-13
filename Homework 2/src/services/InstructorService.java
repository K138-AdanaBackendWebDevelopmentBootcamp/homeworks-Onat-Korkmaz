package services;

import models.Course;
import models.Instructor;
import repositories.CRUDRepository;
import repositories.InstructorRepository;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements CRUDRepository<Instructor>, InstructorRepository {
    EntityManager em = HibernateUtil.buildSF();

    @Override
    public List<Instructor> findAll() {
        em.getTransaction().begin();
        List<Instructor> instructorList = em.createQuery("from Instructor", Instructor.class).getResultList();
        return instructorList;
    }

    @Override
    public Instructor findByID(int id) {
        em.getTransaction().begin();
        Instructor instructor = em.find(Instructor.class,id);
        return instructor;
    }

    @Override
    public void saveToDB(Instructor instructor) {
        try {
            em.getTransaction().begin();
            em.persist(instructor);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDB(Instructor instructor) {
        try {
            em.getTransaction().begin();
            em.remove(instructor);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDB(int id) {
        try {
            em.getTransaction().begin();
            Instructor instructor = findByID(id);
            em.remove(instructor);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void updateDB(Instructor instructor, int id) {
        try {
            em.getTransaction().begin();
            em.merge(instructor);
            em.getTransaction().commit();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Course> getCourseList(Instructor instructor) {
        try {
            em.getTransaction().begin();
            Instructor theInstructor = em.find(Instructor.class,instructor.getId());
            return theInstructor.getCourses();
        }catch (Exception e){
            e.getMessage();
            em.getTransaction().rollback();
        }
        return null;
    }
}
