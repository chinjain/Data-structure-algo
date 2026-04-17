package java8_problems_solutions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxFrequencyCharacter {
    public static void main(String[] args) {

        String input = "aaddbbbccddeeeedd";

       Map.Entry<Character, Long> resp =  input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(resp.getKey() + " " + resp.getValue());
    }
}
