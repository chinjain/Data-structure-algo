//package heap_problem;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class MaxSumCombination {
//
//    public static void main(String[] args) {
//
//        int[] A = {3, 2};
//        int[] B = {1, 4};
//        System.out.println(maxSumCombinations(A, B, 2)); // O(n^2LogN);
//
//        System.out.println(maxSumCombinationsOptimal(
//                new int[]{3, 2},
//                new int[]{1, 4}, 2));
//    }
//
////    private static List<Integer> maxSumCombinationsOptimal(int[] A, int[] B, int k) {
////
////        int n = A.length;
////        Arrays.sort(A);
////        Arrays.sort(B);
////
////    }
//
//    private static List<Integer> maxSumCombinations(int[] A, int[] B, int i) {
//        List<Integer> allSums = new ArrayList<>();
//        for(int a : A){
//           for(int b : B){
//               allSums.add(a + b);
//           }
//        }
//
//        allSums.sort(Collections.reverseOrder());
//        return allSums.subList(0, i);
//    }
//
//
//}
