package binary_search_problems;

public class NthRoot {
    public static void main(String[] args) {
        System.out.println(nthRoot(2, 9));   // 3
        System.out.println(nthRoot(2, 16));  // 4
        System.out.println(nthRoot(2, 25));  // 5

//        brute(2,9);
    }

    private static int nthRoot(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            long ans = 1;

            for(int i = 0; i < n; i++){
                ans *= mid;
                if(ans > m)
                    break;
            }

            if(ans == m)
                return mid;

            if(ans < m)
                low = mid + 1;
            else
                high = mid -1;
        }

        return -1;
    }

    static void brute(int n, int m){
        for(int i = 1; i <= m; i++){
            long power = (long) Math.pow(i, n);
            if(power == m){
                System.out.println("power = " + i);
                break;
            }

            if(power > m)
                break;
        }
    }
}
