package sliding_window_problesm;

public class FindMaxAverageSubarraySum {

    public static void main(String[] args) {

        int [] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;

        optimalSolution(arr, k);


        int maxSum = 0;

        for(int i = 0; i <= arr.length - k; i++){
            int sum = 0;

            for(int j = i; j < i + k; j++){
                sum += arr[j];
            }

            maxSum = Math.max(maxSum, sum/k);
        }

        System.out.println("max :" + maxSum);


    }

    private static void optimalSolution(int[] arr, int k) {

        int sum = 0;
        int maxAvg = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

        maxAvg = sum;

        for(int i = k; i < arr.length; i++){
            sum += arr[i] - arr[i - k];
            maxAvg = Math.max(maxAvg, sum);
        }

        System.out.println(maxAvg/k);

    }

}
