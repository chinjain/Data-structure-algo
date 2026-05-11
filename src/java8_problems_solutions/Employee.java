package java8_problems_solutions;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static List<Employee> getEmployeeData(){
        return Arrays.asList(
                new Employee(1, "Rahul", "IT", 80000),
                new Employee(2, "Amit", "HR", 60000),
                new Employee(3, "Neha", "IT", 95000),
                new Employee(4, "Priya", "Finance", 75000),
                new Employee(5, "Rohit", "HR", 65000),
                new Employee(6, "Ankit", "Finance", 90000),
                new Employee(7, "Rahul", "IT", 80000),   // duplicate name
                new Employee(8, "Simran", "Admin", 50000),
                new Employee(9, "Karan", "Admin", 55000),
                new Employee(10, "Vikas", "IT", 120000)
        );


    }

}
