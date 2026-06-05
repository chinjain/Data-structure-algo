package java8_problems_solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScenerioBasedProblems {
    public static void main(String[] args) {

        EmployeeDto employee1 = new EmployeeDto("SRK","ECE",31,"Male");
        EmployeeDto employee2 = new EmployeeDto("Salman","CS",44,"Male");
        EmployeeDto employee3 = new EmployeeDto("Katrina","ECE",21,"Female");
        EmployeeDto employee4 = new EmployeeDto("Kareena","CS",34,"Female");
        EmployeeDto employee5 = new EmployeeDto("Hrithik","EEE",30,"Male");
        EmployeeDto employee6 = new EmployeeDto("Aish","EEE",25,"Female");

        List<EmployeeDto> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);


        // 1.Find the names of all EmployeeDtos in the CS department, sorted by age in descending order.
        List<EmployeeDto> csSortedEmployeeDtos = list.stream()
                .filter(emp -> emp.department() == "CS")
                .sorted(Comparator.comparingInt(EmployeeDto::age).reversed())
                .toList();
        System.out.println("CS Sorted Employees: " + csSortedEmployeeDtos);

        // 2. Group Employees by department and count how many Employees are in each department.
        Map<String, Long> departmentGroup = list.stream().collect(Collectors.groupingBy(EmployeeDto::department,Collectors.counting()));
        System.out.println("Department wise count: " + departmentGroup);

        // 3.Find the youngest female Employee.
        String youngestFemaleName = list.stream()
                .min(Comparator.comparingInt(EmployeeDto::age))
                .get().name();
        System.out.println("Youngest Female Name: "+youngestFemaleName);

        // 4. Create a map of department -> list of Employee names.
        Map<String,List<String>> departmentMap = list.stream().collect(Collectors.groupingBy(EmployeeDto::department,Collectors.collectingAndThen(Collectors.toList(), emp1 ->
                emp1.stream().map(EmployeeDto::name).toList())));
        System.out.println("Department Map: " + departmentMap);

        // 7. Partition Employees into male and female groups, then list their names.
        Map<String, List<String>> partitionedList =   list.stream().collect(Collectors.groupingBy(e -> {
                    if(e.gender() == "Female") {
                        return "Female";
                    }
                    else if(e.gender() == "Male") {
                        return "Male";
                    }
                    return "";
                },
                Collectors.mapping(e -> e.name(), Collectors.toList())
        ));
        System.out.println("Partitioned List: " + partitionedList);

    }
}


record EmployeeDto(
        String name,
        String department,
        int age,
        String gender
){}