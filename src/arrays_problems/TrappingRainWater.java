package arrays_problems;

public class TrappingRainWater {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		BruteForceAppraoch(arr);
		prefixSuffixApproach(arr);
		twoPointerApproach(arr);
		
		
		/*
		 * 
		 * Here we are following the 2 approaches with single value approach that is 
		 * 
		 * MaxLeft & MaxRight  we will find the max left from left and max right from right side 
		 * 
		 * then we will find the min of both of them and subtract the current index value 
		 * from totalWaterReserved += Math.Min(leftMax,rightMax) - arr[i];
		 * 
		 * this formula will say that you have stored the max water in between the boundaries
		 * 
		 * 
		 */
	}

	private static void twoPointerApproach(int[] arr) {
		int n = arr.length;
		int l = 0, r = n - 1;
		int res = 0;
		int leftMax = arr[l], rightMax = arr[r];

		while (l < r){
			if(leftMax < rightMax){
				l++;
				leftMax = Math.max(leftMax, arr[l]);
				res += leftMax - arr[l];
			}else{
				r--;
				rightMax = Math.max(rightMax, arr[r]);
				res += rightMax - arr[r];
			}
		}


		System.out.println("TrappingRainWater.twoPointerApproach()");
		System.out.println(res);

	}

	private static void prefixSuffixApproach(int[] arr) {

		int n = arr.length;

		int prefinx[] = new int[n];
		int suffix[] = new int[n];

		prefinx[0] = arr[0];

		for (int i = 1; i < n; i++) {
			prefinx[i] = Math.max(prefinx[i - 1], arr[i]);
		}

		suffix[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			suffix[i] = Math.max(suffix[i + 1], arr[i]);
		}

		int waterTrapped = 0;

		for (int i = 0; i < arr.length; i++) {
			waterTrapped += Math.min(prefinx[i], suffix[i]) - arr[i];
		}

		System.out.println("TrappingRainWater.prefixSuffixApproach()");
		System.out.println(waterTrapped);

	}

	private static void BruteForceAppraoch(int[] arr) {

		int waterReserved = 0;

		for (int i = 0; i < arr.length; i++) {
			int j = i;

			int leftMax = 0, rightMax = 0;

			while (j >= 0) {
				leftMax = Math.max(leftMax, arr[j]);
				--j;
			}

			j = i;

			while (j < arr.length) {
				rightMax = Math.max(rightMax, arr[j]);
				j++;
			}

			waterReserved += Math.min(leftMax, rightMax) - arr[i];
		}

		System.out.println("TrappingRainWater.BruteForceAppraoch()");
		System.out.println(waterReserved);

	}

}
