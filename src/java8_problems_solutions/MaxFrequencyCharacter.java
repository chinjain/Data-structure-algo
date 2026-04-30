package java8_problems_solutions;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxFrequencyCharacter {
    public static void main(String[] args) {

        String input = "aaddbbbccddeeeedd";

     input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
               .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
               .forEach( entry -> {
                   System.out.println(entry.getKey() + ":" + entry.getValue());
               });
    }
}
