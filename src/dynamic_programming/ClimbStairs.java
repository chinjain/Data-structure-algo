package dynamic_programming;

public class ClimbStairs {
    public static void main(String[] args) {
        int num = 5;
        // same as climb-stairs
       int ans =  climb(5);
        System.out.println(ans);
    }

    private static int climb(int num) {
        if(num <= 1){
            return 1;
        }
        return climb(num - 1) + climb(num - 2);
    }
}
