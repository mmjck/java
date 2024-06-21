public class Employee implements EmployInterface, ManagedInterface{
    String firstName;
    String lastName;
    Manager manager;
    Double salary;   
    
    @Override
    public void assignManager(Manager manager) {
            this.manager = manager;
    }
     
    @Override
    public void calculateMonthlySalary(int rank) {
        this.salary = (19.5 + (rank * 4)) * 228;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
}
