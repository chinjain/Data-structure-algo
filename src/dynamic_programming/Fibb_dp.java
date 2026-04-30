package dynamic_programming;

import java.util.Arrays;

public class Fibb_dp {

    public static void main(String[] args) {

        int n = 9;
        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for(int i = 0; i <= n; i++){
            System.out.println(dp[i] + " ");
        }


    }
}
