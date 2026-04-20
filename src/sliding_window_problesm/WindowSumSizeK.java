package sliding_window_problesm;

public class WindowSumSizeK {
    public static void main(String[] args) {
        int [] arr = {10,40,-35,5,10,12,9,20};
        int k = 3;
        sumBrute(arr, arr.length, k);
        sumOptimal(arr, arr.length, k);
    }

    private static void sumOptimal(int[] arr, int length, int k) {

        int windSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++){
            windSum += arr[i];
        }

        maxSum = Math.max(maxSum, windSum);

        for(int i = k; i < length; i++){
            windSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum,windSum);
        }

        System.out.print(maxSum);

    }

    private static void sumBrute(int[] arr, int length, int k) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i <= length - k; i++){
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }

        System.out.println(maxSum);
    }
}
