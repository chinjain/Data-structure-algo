package sliding_window_problesm;

public class Minimum_Subarray_With_Required_Sum {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 45, 6, 10, 19 };
		int x = 51;

		bruteForce(arr, x);
		OptimalApproach(arr, x);

	}

	private static void OptimalApproach(int[] arr, int x) {

		int left = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		for(int right = 0; right < arr.length; right++){
			sum += arr[right];

			while (sum >= x){
				minLen = Math.min(minLen, right - left + 1);

				sum -= arr[left++];
			}
		}

		System.out.println("Minimum_Subarray_With_Required_Sum.OptimalApproach()");
		System.out.println(minLen != Integer.MAX_VALUE ? minLen : 0);

	}

	private static void bruteForce(int[] arr, int x) {
		int minLen = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++){
			int sum = 0;

			for(int j = i; j < arr.length; j++){
				sum += arr[i];
				if(sum >= x){
					minLen = Math.min(minLen, j - i + 1);
					break;
				}
			}
		}

		System.out.println("Minimum_Subarray_With_Required_Sum.bruteForce()");
		System.out.println(minLen);

	}

}
