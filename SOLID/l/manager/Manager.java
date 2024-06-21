public class Manager extends Employee implements ManagerInterface{

    @Override
    public void generatePerformanceReview() {
        System.out.println("I am generating performance review as Manger");
    }

    @Override
    public void calculateMonthlySalary(int rank) {
        this.salary = (19.5 + (rank * 4)) * 228;
    }

}
