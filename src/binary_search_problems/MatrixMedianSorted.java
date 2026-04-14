package binary_search_problems;

import java.util.Arrays;

public class MatrixMedianSorted {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        // 1,2,3,3,5,6,6,9,9

        brute(matrix);
        binarySearch(matrix);
    }

    static void binarySearch(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;

        for(int [] row : matrix){
            lo = Math.min(lo, row[0]);
            hi = Math.max(hi, row[m - 1]);
        }

        int required = (n * m + 1) / 2;

        while (lo < hi){
            int mid = lo + (hi - lo) / 2;

            int count = 0;
            for(int[] row : matrix){
                count += countLessEqual(row, mid);
            }

            if(count < required)
                lo = mid + 1;
            else
                hi = mid;
        }

        System.out.println(lo);
    }

    private static int countLessEqual(int[] row, int x) {
        int lo = 0;
        int hi = row.length - 1;

        while (lo <= hi){
            int mid = lo +  (hi - lo)/2;
            if(row[mid] <= x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }

    static void brute(int [][]matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int [] arr = new int[n * m];
        int idx = 0;

        for(int[] row : matrix){
            for(int val : row){
                arr[idx++] = val;
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[(n * m)/2]);

    }
}
