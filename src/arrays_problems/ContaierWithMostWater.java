package arrays_problems;

public class ContaierWithMostWater {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 3 };

		bruteforceApproach(arr);
		optimalApproach(arr);

	}

	private static void optimalApproach(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		int max = Integer.MIN_VALUE;

		while (i < j) {
			int water = (j - 1) * Math.min(arr[i], arr[j]);
			max = Math.max(water, max);

			if (arr[i] < arr[j]) {
				i++;
			} else {
				--j;
			}
		}

		System.out.println("ContaierWithMostWater.optimalApproach()");
		System.out.println(max);

	}

	private static void bruteforceApproach(int[] arr) {
		
		/*
		 * 
		 * 
		 * 
		 * 
		 */

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int water = (j - i) * Math.min(arr[i], arr[j]);
				max = Math.max(max, water);
			}
		}

		System.out.println("ContaierWithMostWater.bruteforceApproach()");
		System.out.println(max);

	}

}
