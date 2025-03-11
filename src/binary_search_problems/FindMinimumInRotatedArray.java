package binary_search_problems;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int lo = 0;
        int hi = arr.length - 1;

        findMin(arr,lo,hi);


    }

    public static void findMin(int[] arr, int lo, int hi) {
        int ans = Integer.MAX_VALUE;
        while(lo <= hi){

        int mid = (lo + hi)/2;

        if(arr[lo] <= arr[hi]){
            ans = Math.min(ans,arr[lo]);
            break;
        }

        if(arr[lo] <= arr[mid]){
            ans = Math.min(ans, arr[lo]);
            lo = mid + 1;
        }else{

            ans = Math.min(ans, arr[mid]);
            hi = mid - 1;

        }
    }

        System.out.println(ans);
    }

}
