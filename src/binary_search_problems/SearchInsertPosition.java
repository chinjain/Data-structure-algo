package binary_search_problems;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] arr = {1,2,4,7};
        int x = 6;

        int lo = 0, hi = arr.length - 1;
        int ans = arr.length;

        while(lo <= hi){

            int mid = lo + (hi - lo)/2;
            if(arr[mid] >= x){

                ans = mid;
                hi = mid - 1;

            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
