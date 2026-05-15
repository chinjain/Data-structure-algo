package java8_problems_solutions;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingSolutions {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployeeData();

        highest_salary_of_employee(employees);

        second_high_salary_deptWise(employees);

        countEmplInEachDepartment(employees);

        avgSalaryByDepartment(employees);

        employeeNameDeptWise(employees);

        deptByMaxEmployees(employees);

        empSalaryGreaterThanAvgSalary(employees);

        sortBySalary(employees);

        firstNonRepeatingCharacter();

    }

    private static void firstNonRepeatingCharacter() {
        String str = "ABACCDEE E";

       char key =  str.chars().mapToObj(c -> (char)c).filter(ch -> ch != ' ')
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
        System.out.println(key);
    }

    private static void sortBySalary(List<Employee> employees) {

        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList().forEach(System.out::println);

    }

    private static void empSalaryGreaterThanAvgSalary(List<Employee> employees) {
        System.out.println("========== Salary greater than avg salary ========");
        double avg = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();

       List<Employee> employeeList =  employees.stream().filter(emp -> emp.getSalary() > avg).toList();
        System.out.println(employeeList);
    }

    private static void deptByMaxEmployees(List<Employee> employees) {
        System.out.println("======= Dept By Max number of Employees ======");

        String total = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println(total);
    }

    private static void employeeNameDeptWise(List<Employee> employees) {
        System.out.println("======= Name of Employees Dept wise ========");

        Map<String, List<String>> empNameDeptWise = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(empNameDeptWise);
    }

    private static void avgSalaryByDepartment(List<Employee> employees) {

        System.out.println("========= AVG Salary By Dept wise ========");
        Map<String, Double> avgSalByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalByDept);
    }

    private static void countEmplInEachDepartment(List<Employee> employees) {

        Map<String,Long> countOfEmp = employees
                .stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(countOfEmp);

    }

    private static void second_high_salary_deptWise(List<Employee> employees) {
        System.out.println("========= 2nd high salary dept wise =========");

        Map<String, Double> deptSalary = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.collectingAndThen(Collectors.toList(), list ->
                list.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get())));

        System.out.println(deptSalary);
    }

    private static void highest_salary_of_employee(List<Employee> employees) {
        System.out.println("=========== highest salary in each department ===========");
        Map<String, Employee> response = employees.stream()
                .collect(Collectors.toMap(Employee::getDept, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println(response);

    }
}
