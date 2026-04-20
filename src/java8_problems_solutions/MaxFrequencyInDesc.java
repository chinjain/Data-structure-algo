package java8_problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxFrequencyInDesc {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,3,3,4,4,5,5,3,4,1);

       Map<Integer,Long> output = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((m1,m2) -> Long.compare(m2.getValue(), m1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        System.out.println(output);


        Map<Integer, Integer> freq = new HashMap<>();

        for(int ele : nums){
            freq.put(ele, freq.getOrDefault(ele,0) + 1);
        }

        List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(freq.entrySet());

        entries.sort((a,b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer,Integer> entry : entries){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
