package java8_problems_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDescending {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(11,11,1,3,5,6,5);

        input.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++",
                "COBOL", "C");

        listOfStrings.sort(Comparator.comparing(String::length));
        System.out.println(listOfStrings);

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98,
                21.12,42.90);

        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
