public class CEO extends BaseEmployee implements ManagerInterface{
    @Override
    public void calculateMonthlySalary(int rank) {
        this.salary = (19.5 + (rank + 4)) * 220;
    }

    @Override
    public void generatePerformanceReview() {
        
        System.err.println("I am generating performance review as CEO");
    }


    void fireSomeone(Employee employee){
        System.out.println(employee.getFirstName());
        System.out.println("you are fired!");
    }
    
}
