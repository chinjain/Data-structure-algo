package binary_search_problems;

public class FindTimesArrayIsRotated {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int lo = 0;
        int hi = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (lo <= hi){
            int mid = (lo + hi)/2;

            if(arr[lo] <= arr[hi]){
                ans = lo;
                break;
            }

            if(arr[lo] <= arr[mid]){
                ans = lo;
                lo = mid + 1;
            }else{
                ans = mid;
                hi = mid - 1;
            }
        }

        System.out.println("Array is rotated :" + ans);

    }


}
