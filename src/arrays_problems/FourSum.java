package arrays_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        int target  = 0;

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(a);

        for(int i = 0; i < a.length - 3; i++){
            if(i > 0 && a[i] == a[i - 1])
                continue;

            for (int j = i + 1; j < a.length - 2; j++) {

                int left = j + 1;
                int right = a.length - 1;

                while (left < right){
                    long sum = (long) a[i] + a[j] + a[left] + a[right];

                    if(sum == target){
                        result.add(Arrays.asList(a[i],a[j],a[left],a[right]));
                        left++;
                        right--;

                        while (left < right && a[left] == a[left - 1])
                            left++;

                        while (left < right && a[right] == a[right + 1])
                            right++;
                    }else if(sum > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
