package Exercises.CompanyRoster;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public static Employee parseEmployee(String[] data) {
        validateDataLength(data);
        String name = data[0];
        double salary = Double.parseDouble(data[1]);
        String position = data[2];
        String department = data[3];

        switch (data.length) {
            case 4:
                return new Employee(name, salary, position, department);

            case 5:
                if (isANumber(data[4])) {
                    int age = Integer.parseInt(data[4]);
                    return new Employee(name, salary, position, department, age);
                } else {
                    String email = data[4];
                    return new Employee(name, salary, position, department, email);
                }

            case 6:
                int age;
                String email;
                if (isANumber(data[4])) {
                    age = Integer.parseInt(data[4]);
                    email = data[5];
                } else {
                    email = data[4];
                    age = Integer.parseInt(data[5]);
                }
                return new Employee(name, salary, position, department, email, age);
        }
        return null;
    }

    private static void validateDataLength(String[] data) {
        if (4 > data.length) {
            throw new IllegalArgumentException(
                    "Cannot create employee without name, salary, position and department");
        } else if (data.length > 6) {
            throw new IllegalArgumentException(
                    "Cannot create employee with more data than needed");
        }
    }

    private static boolean isANumber(String num) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(num);

        return matcher.find();
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d"
                , this.name, this.salary, this.email, this.age);
    }
}
