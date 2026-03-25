package streamsJava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListToEven {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,3,4,5,6,123,54,13,6,567,8,807,3,425,6,7);

        //Question 1 : find even number from list:

        List<Integer> even =  integers.stream().filter(n -> n%2 == 0).toList();

        System.out.println("Even number List : " +  even);


        //QUestion 2 : find max values from list of integer
        int val = integers.stream().max(Integer::compare).get();
        System.out.println("Max Value is " + val);

        //Question 3: Find sum of int from list

        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum is : " + sum);

        //Ques 4 Uppercast

        List<String> strings = Arrays.asList("bcjd","bob","kaje","chin","jaini");

        List<String> resp = strings.stream().map(String::toUpperCase).toList();
        System.out.println("Uppercase list : " + resp);

        //sort the list of integer

        List<Integer> sort = integers.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).toList();
        System.out.println("Sort list :" + sort);

        Long largeElement = integers.stream().filter(num -> num > 5).count();
        System.out.println("Greater than 5 : " + largeElement);
    }
}
