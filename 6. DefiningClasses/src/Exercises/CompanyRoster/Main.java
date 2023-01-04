package Exercises.CompanyRoster;

//3/11/2021

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departmentsByName = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Employee employee = Employee.parseEmployee(data);

            String departmentName = data[3];
            departmentsByName.putIfAbsent(departmentName, new Department(departmentName));
            departmentsByName.get(departmentName).hireAnEmployee(employee);
        }
        if (!departmentsByName.isEmpty()) {
           Department department = bestDepartment(departmentsByName);

            System.out.println("Highest Average Salary: " + department.getName());

            department
                    .sortedEmployees((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                    .forEach(System.out::println);
        }
    }

    private static Department bestDepartment(Map<String, Department> departmentsByName) {
        return departmentsByName.values()
                .stream()
                .max(Comparator.comparingDouble(Department::getAverageSalary))
                .orElse(null);
    }
}
