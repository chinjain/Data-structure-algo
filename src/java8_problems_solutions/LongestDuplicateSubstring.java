package java8_problems_solutions;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestDuplicateSubstring {

    public static void main(String[] args) {
        String s = "banana";
        int n = s.length();

       String output = IntStream.range(0,n)
                .boxed()
                .flatMap(i ->
                        IntStream.rangeClosed(i + 1, n)
                                .mapToObj(j -> s.substring(i,j)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .map(Map.Entry::getKey)
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println(output);

    }
}
