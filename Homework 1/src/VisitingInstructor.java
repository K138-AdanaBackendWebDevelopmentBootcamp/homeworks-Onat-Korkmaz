public class VisitingInstructor extends Instructor{
    private double fixedSalary;

    public VisitingInstructor(String name, String address, String phoneNo, double fixedSalary) {
        super(name, address, phoneNo);
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
