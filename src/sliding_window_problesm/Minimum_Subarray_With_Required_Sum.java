package sliding_window_problesm;

public class Minimum_Subarray_With_Required_Sum {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 45, 6, 10, 19 };
		int x = 51;

		bruteForce(arr, x);
		OptimalApproach(arr, x);

		bestCode_appraoch(arr,x);
	}

	static void bestCode_appraoch(int [] a, int k){

		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int windowSum = 0;

		for(int right = 0; right < a.length; right++){
			windowSum += a[right];

			if(right - left + 1 == 3){
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= a[left++];
			}
		}

		System.out.println("Window sum" + maxSum);

	}

	private static void OptimalApproach(int[] arr, int x) {

		int currSum = 0;
		int minLen = arr.length + 1;

		int start = 0, end = 0;
		while (end < arr.length) {
			while (currSum <= x && end < arr.length) {
				currSum += arr[end++];
			}

			while (currSum > x && start < arr.length) {
				if (end - start < minLen) {
					minLen = end - start;
				}

				currSum -= arr[start++];
			}
		}
		
		System.out.println("Minimum_Subarray_With_Required_Sum.OptimalApproach()");
		System.out.println(minLen);

	}

	private static void bruteForce(int[] arr, int x) {
		int minLen = arr.length + 1;

		for (int i = 0; i < arr.length; i++) {

			int curr_sum = arr[i];

			if (curr_sum > x) {
				System.out.println(1);
				return;
			}

			for (int j = i + 1; j < arr.length; j++) {
				curr_sum += arr[j];

				if (curr_sum == x && (j - i + 1) < minLen) {
					System.out.println(arr[j]);
					minLen = j - i + 1;
				}
			}
		}

		System.out.println("Minimum_Subarray_With_Required_Sum.bruteForce()");
		System.out.println(minLen);

	}

}
