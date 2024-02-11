package EMS;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeManagementSystem implements EmployeeSorter {
    private List<Employee> employees;

    public EmployeeManagementSystem(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    //use of predicate which is a type of functional interface used to test a given condition
    public List<Employee> filterEmployees(Predicate<Employee> predicate){
        List<Employee> filteredEmployees = new ArrayList<>();
        for(Employee employee:employees){
            if(predicate.test(employee)){
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    //use of consumer which is another functional interface that takes an input and returns nothing
    public void forEachEmployee(Consumer<Employee> consumer){
        for(Employee employee : employees){
            consumer.accept(employee);
        }
    }

    public void sortAndPrintByName(){
        List<Employee> sortedByName = sortByName(getEmployees());
        System.out.println("Employees sorted by name: " + sortedByName);
    }

    public void sortAndPrintBySalary(){
        List<Employee> sortedBySalary = sortBySalary(getEmployees());
        System.out.println("Employees sorted by salary: " + sortedBySalary);
    }


}
