package binary_search_problems;

public class FindPeakElement {

    public static void main(String[] args) {

        int [] arr = {1,2,4,5,7,8,3};

        findPeak_brute(arr);
        
        findPeak_binarySearch(arr);

    }

    private static void findPeak_binarySearch(int[] arr) {
        int n = arr.length;

        //if there is only one element

        if(n == 1){
            System.out.println(0);
        }

        // check if first element is peak;

        if(arr[0] > arr[1]){
            System.out.println(arr[0]);
        }

        //check if last element is peak
        if(arr[n - 1] > arr[n - 2]){
            System.out.println(arr[n - 1]);
        }

        int l = 1, r = n - 2;
        while (l <= r){
            int mid = (l + r)/2;

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                System.out.println(arr[mid]);
            }

            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }


    }

    private static void findPeak_brute(int[] arr) {

        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            if(i > 0 &&  arr[i] >= arr[i-1] && arr[i] >= arr[i+1]){
                System.out.println(arr[i]);
                break;
            }
        }
    }

}
