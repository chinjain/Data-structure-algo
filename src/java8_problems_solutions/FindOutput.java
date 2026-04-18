package java8_problems_solutions;

import java.util.stream.Stream;

public class FindOutput {
    public static void main(String[] args) {
        int[] counter = {0};
        Stream.of("apple","banana","cherr")
                .filter(a -> {
                    counter[0]++;
                    return a.startsWith("a");
                });

        System.out.println(counter[0]);
    }
}
