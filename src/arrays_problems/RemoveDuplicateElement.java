package arrays_problems;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicateElement {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 2, 3, 3 };
		bruteForce(arr);
		optimalApproach(arr);

	}

	private static void optimalApproach(int[] arr) {
		System.out.println("\n" + "RemoveDuplicateElement.optimalApproach()");

		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}

//		for (int id = i + 1; i < arr.length; i++) {
//			arr[i] = 0;
//		}

		int j = 0;
		while (j <= i) {
			System.out.print(arr[j++] + " ");
		}

	}

	private static void bruteForce(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int x : arr) {
			set.add(x);
		}

		int j = 0;
		int a[] = new int[set.size()];

		for (int x : set) {
			a[j++] = x;
		}

		Arrays.stream(a).forEach(System.out::print);
	}

}
