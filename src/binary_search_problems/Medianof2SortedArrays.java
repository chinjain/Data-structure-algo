package binary_search_problems;

public class Medianof2SortedArrays {

    public static void main(String[] args) {

        int[] a = {1,2};
        int[] b = {3,4};
        brute_median();
        optimal_median(a,b);
    }

    private static double optimal_median(int[] a, int[] b) {
        //ensure a is smaller than b

        if(a.length > b.length)
            return optimal_median(b,a);

        int n = a.length,m = b.length;
        return 0;

    }

    //Time: O(N+M) Space: O(N+M)
    private static void brute_median() {
        int[] a = {1,2};
        int[] b = {3,4};

        int n = a.length;
        int m = b.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m){
            if(a[i] <= b[j])merged[k++] = a[i++];
            else merged[k++] = b[j++];
        }
        while (i < n) merged[k++] = a[i++];
        while (j < m) merged[k++] = b[j++];

        int total = n + m;
        if(total % 2 == 1)
            System.out.println(merged[total/2]);
        else
            System.out.println((merged[total/2-1] + merged[total/2]) / 2.0);
    }
}
