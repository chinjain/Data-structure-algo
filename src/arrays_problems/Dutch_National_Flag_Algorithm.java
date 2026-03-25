package arrays_problems;

import java.util.Arrays;

public class Dutch_National_Flag_Algorithm {

	public static void main(String[] args) {

		int[] nums = { 2, 0, 2, 1, 1, 0 };
//		sortColors(nums, nums.length);

		bruteForc(nums);

	}

	private static void bruteForc(int[] nums) {

		System.out.println("nums = " + Arrays.toString(nums));

		int count_0 = 0, count_1 = 0, count_2 = 0;
		for (int i = 0; i < nums.length; i++){
			if (nums[i] == 0)
				count_0++;
			else if (nums[i] == 1)
				count_1++;
			else
				count_2++;
		}

		for(int i = 0; i < count_0; i++){
			nums[i] = 0;
		}
		for(int i = count_0; i < count_1; i++){
			nums[i] = 1;
		}
		for(int i = count_0 + count_1; i < nums.length; i++){
			nums[i] = 2;
		}

		System.out.println("nums = " + Arrays.toString(nums));

	}

	private static void sortColors(int[] arr, int n) {

		int lo = 0, mid = 0, hi = n - 1;

		while (mid <= hi) {
			if (arr[mid] == 0) {
				swap(arr, lo, mid);
				lo++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, hi);
				hi--;
			}
		}
		Arrays.stream(arr).forEach(System.out::print);
	}

	private static void swap(int[] arr, int lo, int mid) {
		int temp = arr[lo];
		arr[lo] = arr[mid];
		arr[mid] = temp;
	}
}
