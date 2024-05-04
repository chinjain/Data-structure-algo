package arrays_problems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Next_Permutation {

	public static void main(String[] args) {

		/*
		 * This problem will solve using the Lexicographical order
		 * 
		 * We have to check that the order of the array sequence is greater than the
		 * previous array sequence. The output will be just larger sequence of the
		 * array.
		 * 
		 * next greate lexicographically greater permutation of a given sequence number 
		 * 
		 */

		int arr[] = { 1, 3, 2 };

		bruteforce_1(arr);
		optimal(arr);

	}

	private static void bruteforce_1(int[] arr) {
		/*
		 * 
		 * 
		 * Finding All possible Permutations
		 * 
		 * 2. Store all of them
		 * 
		 * 3. search input from all possible permutation
		 * 
		 * 4. print the next permutation
		 * 
		 */

	}

	private static void optimal(int[] arr) {

		/*
		 * 
		 * Step 1: First we need to find the break point the array where i < i+1
		 * 
		 * from the last of the array we will find the solution for the same and update
		 * the I to indx value
		 * 
		 * if(ind == -1) then we don't have any break point we will reverse the whole
		 * array
		 * 
		 * 
		 * Step 2: If we find the next greater Element
		 * 
		 * we will find the i2 which is A[i] > A[ind]
		 * 
		 * 
		 * step 3: we will reverse the whole array from ind + 1 to list size();
		 * 
		 * then we will return the list with it's next permutation of it
		 * 
		 * 
		 */

		int ind = -1;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				ind = i;
				break;
			}
		}

		if (ind == -1) {
			Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue)
					.forEach(System.out::println);
			return;
		}

		for (int i = arr.length - 1; i >= 0; --i) {
			if (arr[i] > arr[ind]) {
				int temp = arr[i];
				arr[i] = arr[ind];
				arr[ind] = temp;
				break;
			}
		}

		// reverse the sub list

		int j = arr.length - 1;

		while (ind < j) {

			int temp = arr[ind];
			arr[ind] = arr[j];
			arr[j] = temp;

			ind++;
			--j;

		}

		Arrays.stream(arr).forEach(System.out::println);

	}

}
