package java8_problems_solutions;

import java.util.List;

public class SumOfSquareOfEvenNum {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,45,23,43,44,64,90,3,9,7,77,57,89);
        int sum =  nums.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum();
        System.out.println(sum);
    }
}
