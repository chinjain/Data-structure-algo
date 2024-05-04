package arrays_problems;

import java.util.Arrays;

public class ArithmeticProgression {

	public static void main(String[] args) {

		int arr[] = { 3, 7 };
		bruteForceAP(arr);

	}

	private static void bruteForceAP(int[] arr) {
		Arrays.sort(arr);
		
		int d = arr[1] - arr[0];
		int numToAdd = -1;
		boolean numAdded = false;
		
		for(int i = 2; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			
			if(diff != d) {
				if(numAdded) {
					System.out.println(false);
				}
			}
		}

	}

}
