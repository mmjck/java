abstract class BaseEmployee implements EmployInterface {
    String firstName;
    String lastName;
    Manager manager;
    Double salary;

    @Override
    public void calculateMonthlySalary(int rank) {
        this.salary = (19.5 + (rank * 4)) * 228;
    }

}
