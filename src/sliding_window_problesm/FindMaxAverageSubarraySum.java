package sliding_window_problesm;

public class FindMaxAverageSubarraySum {

    public static void main(String[] args) {

        int [] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;

        optimalSolution(arr, k);


    }

    private static void optimalSolution(int[] arr, int k) {

        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

        maxSum = sum;

        for(int i = k; i < arr.length; i++){
            // we will include the current value and remove the last index
            sum += arr[i] - arr[i - k];

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum/2);

    }

}
