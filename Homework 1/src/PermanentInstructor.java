public class PermanentInstructor extends Instructor{
    private double hourlySalary;

    public PermanentInstructor(String name, String address, String phoneNo, double hourlySalary) {
        super(name, address, phoneNo);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
