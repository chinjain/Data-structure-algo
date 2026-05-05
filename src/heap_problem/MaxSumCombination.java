package heap_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaxSumCombination {

    public static void main(String[] args) {

        int[] A = {3, 2};
        int[] B = {1, 4};
//        System.out.println(maxSumCombinations(A, B, 2));

        System.out.println(maxSumCombinationsOptimal(A,B,2));

    }

    private static List<Integer> maxSumCombinationsOptimal(int[] A, int[] B, int k) {

        int n = A.length;

        //sort both the arrays and the last elements will have the max element with sum max
        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Set<String> visit = new HashSet<>();
        queue.offer(new int[]{A[n - 1] + B[n - 1], n - 1, n - 1});

        visit.add((n-1) + "," + (n - 1));
        List<Integer> result = new ArrayList<>();

        while (k-- > 0 && !queue.isEmpty()){
            int[] curr = queue.poll();
            int sum = curr[0];
            result.add(sum);
            int i = curr[1];
            int j = curr[2];

            if(i - 1 >= 0 && !visit.contains((i -1) +","+j)){
                queue.offer(new int[]{A[i-1] + B[j],i - 1, j});
                visit.add((i-1)+","+j);
            }

            if(j - 1 >= 0 && !visit.contains(i + "," + (j - 1))){
                queue.offer(new int[]{A[i] + B[j - 1],i, j - 1});
            }
        }

        return result;
    }

    private static List<Integer> maxSumCombinations(int[] A, int[] B, int i) {
        List<Integer> allSums = new ArrayList<>();
        for(int a : A){
           for(int b : B){
               allSums.add(a + b);
           }
        }

        //sort all sums in descending order
        allSums.sort(Collections.reverseOrder());
        //fetch the top max k sums from the list of combination sum.
        return allSums.subList(0, i);
    }


}
