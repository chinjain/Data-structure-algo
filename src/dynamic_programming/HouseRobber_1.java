package dynamic_programming;

public class HouseRobber_1 {

    public static void main(String[] args) {
        int[] num = {2,7,9,3,1};

        int ans = rob_brute(num,num.length - 1);
        System.out.println(ans );

        int opt_ans = rob_opt(num);
        System.out.println("optimal " + opt_ans);
    }

    private static int rob_opt(int[] num) {
        int n = num.length;
        if(n == 1)
            return num[0];

        int[] dp = new int[n];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(num[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];

    }

    private static int rob_brute(int[] num, int idx) {
        if(idx < 0)
            return 0;

        if(idx == 1)
            return num[0];

        return Math.max(num[idx] + rob_brute(num, idx - 2), //rob
                rob_brute(num, idx - 1)); // skip
    }
}
