package arrays_problems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_1 {
    public static void main(String[] args) {

        brute();
        majorityElement();
    }

    private static void majorityElement() {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : arr){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > (arr.length / 2)){
                System.out.println(entry.getKey());
                break;
            }
        }
    }

    static void brute(){
        int[] arr = {2, 2, 1, 1, 1, 1, 2, 2, 1};
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] == arr[i])
                    count++;
            }

            if(count > (n/2)){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
