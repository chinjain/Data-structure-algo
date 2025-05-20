package dynamic_programming;

import java.util.Arrays;

public class Fibb_dp {

    public static void main(String[] args) {

        int n = 9;
        int [] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int fact = fibb(n, dp);

        System.out.println(fact);


    }

    public static int fibb(int n, int[] dp){
        if(n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = fibb(n-1, dp) + fibb(n -2, dp);
    }
}
