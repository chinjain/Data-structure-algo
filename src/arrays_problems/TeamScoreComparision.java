package arrays_problems;

import java.util.Arrays;

public class TeamScoreComparision {

    public static void main(String[] args) {
        int[] a = {0,1,2,9};
        int[] b = {1};

        Arrays.sort(a);
        int[] result = compareScores(a,b);

        System.out.println(Arrays.toString(result));
    }

    private static int[] compareScores(int[] a, int[] b) {
        int[] ans = new int[b.length];

        for(int i = 0; i < b.length; i++){
            ans[i] = upperBound(a, b[i]);
        }

        return ans;
    }

    private static int upperBound(int[] a, int tgt) {
        int l = 0, h = a.length - 1;

        while(l <= h){
            int mid = (l + h) / 2;

            if(a[mid] <= tgt)
                l = mid + 1;
            else
                h = mid - 1;
        }

        return l;
    }
}
