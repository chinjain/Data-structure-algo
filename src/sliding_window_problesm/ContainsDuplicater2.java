package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicater2 {

    /*

    You are given an integer array nums and an integer k,
    return true if there are two distinct indices i and j in the array such that
    nums[i] == nums[j] and abs(i - j) <= k, otherwise return false.

     */
    public static void main(String[] args) {

        int [] a = {1,2,3,1};
        int k = 3;
        optimal(a, k);
        bruteforce(a,k);


    }

    private static void bruteforce(int[] a, int k) {

        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] == a[j] && Math.abs(i - j) <= k){
                    System.out.println("true");
                    return;
                }

            }
        }

        System.out.println("false");

    }

    private static void optimal(int[] a, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < a.length; i++){
            if(map.containsKey(a[i]) && i - map.get(a[i]) <= k){
                System.out.println("true");
                return;
            }
            map.put(a[i], i);
        }

        System.out.println("FALSE");

    }

}
