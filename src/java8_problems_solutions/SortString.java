package java8_problems_solutions;

import java.util.Arrays;
import java.util.List;

public class SortString {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("cj","jk","rowling","ball");

        List<String> sortedName = names.stream().sorted().toList();
        System.out.println(sortedName);
    }
}
