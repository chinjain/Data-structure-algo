package java8_problems_solutions;

import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1,2,3,3,4,2,2,5,6,3);
        List<Integer> distinctElement = nums.stream().distinct().toList();
        System.out.println(distinctElement);

    }
}
