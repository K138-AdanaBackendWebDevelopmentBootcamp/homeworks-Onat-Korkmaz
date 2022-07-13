package controllers;

import models.Course;
import models.Instructor;
import services.InstructorService;

import java.util.List;

public class InstructorController {
    InstructorService instructorService = new InstructorService();

    public List<Instructor> listAllInstructors() {
        return instructorService.findAll();
    }

    public Instructor findByID(int id) {
        return instructorService.findByID(id);
    }

    public void saveInstructor(Instructor instructor) {
        instructorService.saveToDB(instructor);
    }

    public void deleteInstructor(Instructor instructor) {
        instructorService.deleteFromDB(instructor);
    }

    public void deleteInstructor(int id) {
        instructorService.deleteFromDB(id);
    }

    public void updateInstructor(Instructor instructor, int id) {
        instructorService.updateDB(instructor,id);
    }

    public List<Course> getCourseList(Instructor instructor) {
        return instructorService.getCourseList(instructor);
    }
}
