package binary_search_problems;

public class SqrtOfX {

    public static void main(String[] args) {
        int x = 35;
        bs_sqrt(x);
        
    }

    private static void bs_sqrt(int x) {

        int l = 1, r = x;
        int res = 0;

        while (l <= r){
            int mid = (l + r)/2;

            if(mid * mid <= x){
                res = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        System.out.println(res);

    }
}
