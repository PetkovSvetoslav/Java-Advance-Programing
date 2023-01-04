package cafe;

import java.util.*;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;
    public String getName() {
        return name;
    }



    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
            boolean alreadyInList = false;
            for (Employee e : employees) {
                if (e.getName().equals(employee.getName())) {
                    alreadyInList = true;
                    break;
                }
            }
            if (!alreadyInList && capacity > employees.size()) {
                employees.add(employee);
            }
        }

    public boolean removeEmployee(String name){
        for (int index = 0; index < employees.size(); index++) {
            if (employees.get(index).getName().equals(name)){
              employees.remove(index);
                return true;
            }
        }
        return  false;
    }

    public Employee getOldestEmployee(){
        Employee oldest= employees.get(0);
        for (Employee emp :employees) {
            if (emp.getAge()> oldest.getAge()){
                oldest=emp;
            }
        }
        return oldest;
    }

    public  Employee getEmployee(String name){
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)){
                return employees.get(i);
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Employees working at Cafe ").append(this.getName()).append(":").append(System.lineSeparator());

        for (Employee currentPerson:employees) {
            stringBuilder.append(currentPerson).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
