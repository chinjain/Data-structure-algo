package arrays_problems;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };

		bruteForce(arr);
		optimalApproach(arr);
		bruteForce_Approach_2(arr);

	}

	private static void bruteForce_Approach_2(int[] arr) {

		System.out.println("ProductOfArrayExceptItself.bruteForce_Approach_2()");

		int mul = 1;
		int result[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				mul *= arr[i];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[i] = mul / arr[i];
			}

		}

		Arrays.stream(result).forEach((s) -> {
			System.out.print(s + " ");
		});

	}

	private static void optimalApproach(int[] arr) {

		int prefixArray[] = new int[arr.length];
		int suffixArray[] = new int[arr.length];

		prefixArray[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			prefixArray[i] = prefixArray[i - 1] * arr[i - 1];
		}

		suffixArray[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			suffixArray[i] = suffixArray[i + 1] * arr[i + 1];
		}

		int res[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = prefixArray[i] * suffixArray[i];
		}
		
		System.out.println("============ProductOfArrayExceptItself.optimalApproach()");
		Arrays.stream(res).forEach(System.out::println);
	}
	
	private static void bruteForce(int[] arr) {

		int[] result = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			result[i] = 1;
			for (int j = 0; j < arr.length; j++) {

				if (i != j) {
					result[i] *= arr[j];
				}

			}
		}

		Arrays.stream(result).forEach(System.out::println);
	}

}
