public class Main {
    public static void main(String[] args) {
       Manager manager = new Manager();
       manager.firstName = "Joao";
       manager.lastName = "das Neves";
       manager.calculateMonthlySalary(4);


       Employee employee = new Employee();
       employee.firstName = "Maria";
       employee.lastName = "das Dores";
       employee.calculateMonthlySalary(2);


       CEO ceo = new CEO();
       employee.firstName = "Maria";
       employee.lastName = "das Dores";
       employee.calculateMonthlySalary(2);
    }
}
