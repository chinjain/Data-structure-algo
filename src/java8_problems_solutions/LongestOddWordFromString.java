package java8_problems_solutions;

import java.util.Comparator;
import java.util.List;

public class LongestOddWordFromString {
    public static void main(String[] args) {

        List<String> words = List.of("Hell0000","chinmuetjoapw");

        String word = words.stream().filter(w -> w.length() % 2 != 0)
                .max(Comparator.comparingInt(String::length)).orElse("Better luck next time");

        System.out.println(word);
    }
}
