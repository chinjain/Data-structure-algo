package arrays_problems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_2 {

    /*
        find all the element having count > n / 2
     */


    public static void main(String[] args) {
        brute();
        optimal();
    }

    static void brute(){
        int[] arr = {2, 2,2,2,2,2,2, 1, 1, 15,4,4,4,2,0,0,0,0,0,0,0};
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int cnt = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == arr[i])
                    cnt++;
            }

            if(cnt > (arr.length / 3) &&
                    !result.contains(arr[i]))
                result.add(arr[i]);
        }

        System.out.println(result);
    }


    /*
    Key insight:
  At most 2 elements can appear > N/3 times

Boyer Moore for N/3:
  Maintain 2 candidates + 2 counts

  For each element:
    If matches candidate1 → count1++
    If matches candidate2 → count2++
    If count1==0 → new candidate1
    If count2==0 → new candidate2
    Else → count1--, count2--

  Then verify both candidates
     */

    static void optimal(){

    }
}
