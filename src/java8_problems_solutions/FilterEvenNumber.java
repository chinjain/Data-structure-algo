package java8_problems_solutions;

import java.util.List;

public class FilterEvenNumber {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> even = nums.stream().filter(ele -> ele % 2 == 0).toList();
        System.out.println(even);

        List<String> names = List.of("abvd","Chinmay","tuv","xyz");
        List<String> upperCase = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCase);
    }
}
