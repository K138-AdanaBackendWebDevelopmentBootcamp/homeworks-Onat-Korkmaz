package models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class VisitingInstructor extends Instructor {
    private double fixedSalary;

    public VisitingInstructor(String name, String address, String phoneNo, List<Course> courses, double fixedSalary) {
        super(name, address, phoneNo, courses);
        this.fixedSalary = fixedSalary;
    }

    public VisitingInstructor() {
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
