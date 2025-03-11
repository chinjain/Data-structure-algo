package arrays_problems;

import java.util.Arrays;

public class Duplicate_N_1_Integer{

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 2, 3 };
		bruteForce(arr, arr.length);
		optimal(arr, arr.length);

	}

	private static void optimal(int[] arr, int length) {
		
		System.out.println("Duplicate_N_1_Integer.optimal()");

		int freq[] = new int[length + 1];

		for (int i = 0; i < length; i++) {
			if (freq[arr[i]] == 0) {
				freq[arr[i]] = 1;
			} else {
				System.out.println(arr[i]);
				return;
			}

		}

	}

	private static void bruteForce(int[] arr, int length) {
		Arrays.sort(arr);
		for (int i = 0; i < length; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println(arr[i]);
				return;
			}
		}
	}

	
}
