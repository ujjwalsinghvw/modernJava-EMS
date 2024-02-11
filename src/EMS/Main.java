package EMS;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        System.out.println("Hi and welcome to EMS");

        //Add employees
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addEmployee(new Employee(1, "Archie Andrews", 35000, LocalDate.of(2020,1,1)));
        ems.addEmployee(new Employee(2, "Veronica Lodge", 50000, LocalDate.of(2019,6,1)));
        ems.addEmployee(new Employee(3, "Betty Cooper", 40000, LocalDate.of(2021,3,15)));
        ems.addEmployee(new Employee(4, "Jughead Jones", 45000, LocalDate.of(2022,8,19)));

        //using a predicate to filter employees by salary
        Predicate<Employee> salaryPredicate= employee -> employee.getSalary()>40000;
        List<Employee> highSalaryEmployees = ems.filterEmployees(salaryPredicate);
        System.out.println(highSalaryEmployees);

        //using a consumer to print employee details;
        Consumer<Employee> printDetails = employee -> employee.toString();
        ems.forEachEmployee(printDetails);

        //using a function to calculate bonus based on salary
        Function<Employee, Double> calcBonus = employee -> employee.getSalary() * 0.1;
        double bonus = calcBonus.apply(ems.getEmployees().get(0));
        System.out.println("Bonus for Archie Andrews: "+ bonus);

        //using Date and Time API to calculate tenure of an employee
        Employee e = ems.getEmployees().get(0);
        System.out.println("Tenure of Archie Andrews: " + e.getTenureInYears() +" years");

        // using default methods from Employee sorter interface to sort employees
        ems.sortAndPrintByName();
        ems.sortAndPrintByName();


    }
}
