package java8_problems_solutions;

import java.util.List;

public class SumOfAll {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,4,50);

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }
}
