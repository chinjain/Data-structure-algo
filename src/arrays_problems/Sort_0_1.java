package arrays_problems;

import java.util.Arrays;

public class Sort_0_1 {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0 };
		
		int i = 0; 
		int j = -1;
		while(i < arr.length) {
			if(arr[i] == 0) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			i++;
		}
		
		System.out.println(Arrays.toString(arr));
		
		countAndSort(arr);
	}

	private static void countAndSort(int[] arr) {
		int countZero = 0;
		int [] ans = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				countZero++;
			}
		}
		
		for(int i = 0; i < countZero; i++) {
			ans[i] = 0;
		}
		
		for(int i = countZero; i <arr.length ; i++) {
			ans[i] = 1;
		}
		
		System.err.println(Arrays.toString(ans));
		
	}

}
