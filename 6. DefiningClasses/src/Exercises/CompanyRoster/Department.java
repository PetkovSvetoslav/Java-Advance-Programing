package Exercises.CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Department {
    private final String name;
    private final List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(this.employees);
    }

    public void hireAnEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAverageSalary() {
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.00);
    }

    public List<Employee> sortedEmployees(Comparator<Employee> comparator) {
        return this.employees.stream()
                .sorted(comparator)
                .collect(Collectors.toUnmodifiableList());
    }
}
