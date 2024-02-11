package EMS;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface EmployeeSorter {
    //implementing default methods and streams API
    default List<Employee> sortByName(List<Employee> employees){
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    default List<Employee> sortBySalary(List<Employee> employees){
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }
}
