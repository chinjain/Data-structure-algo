package javaStream_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FindMaxAgeOfStudent {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("John", 20, "Male"), new Student("Jane", 22, "Female"),
				new Student("Tom", 21, "Male"), new Student("Lucy", 23, "Female"));

		Optional<Student> max = list.stream().max(Comparator.comparing(Student::getAge));

		System.out.println("==================Max age of student from the list is =============================");
		System.out.println(max.get());

		System.out.println("=============== Average of male & Female students ==========================");
		OptionalDouble maleAge = list.stream().filter(s -> s.getGender().equalsIgnoreCase("male"))
				.mapToInt(s -> s.getAge()).average();
		OptionalDouble femaleAge = list.stream().filter(s -> s.getGender().equalsIgnoreCase("male"))
				.mapToInt(s -> s.getAge()).average();
		System.out.println(maleAge.getAsDouble());
		System.out.println(femaleAge.getAsDouble());

		System.out.println("====== Get A map of male & female and value as List<String> ===================");

		Map<String, List<Student>> genderBasedMap = list.stream().collect(Collectors.groupingBy(Student::getGender));
		genderBasedMap.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		});

	}

}

class Student {
	private String name;
	private int age;
	private String gender;

	public Student(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
	}
}