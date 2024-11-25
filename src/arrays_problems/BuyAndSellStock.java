package arrays_problems;

public class BuyAndSellStock {

	public static void main(String[] args) {

		int arr[] = { 7, 1, 5, 3, 6, 4 };
		brute(arr);
		optimal(arr);
		approach2(arr);
	}

	private static void approach2(int[] arr)
	{

		int left = 0;
		int right = 1;
		int maxProfit = 0;
		while (right < arr.length) {
			if (arr[left] < arr[right]) {
				maxProfit = Math.max(maxProfit, arr[right] - arr[left]);
			} else {
				left = right;
			}
			right++;
		}
		
		System.out.println("BuyAndSellStock.approach2()");
		System.out.println(maxProfit);
	}

	private static void optimal(int[] arr) {
		/*
		 * Approach Is as follow :
		 * 
		 * we will find the min and max and then in the max we will find max(max, index
		 * - min); this will be the most optimal apparoach and solve in O(n) Time
		 * Complexity
		 * 
		 */
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i] - min);
		}
		System.out.println("BuyAndSellStock.optimal()");
		System.out.println(max);
	}

	private static void brute(int[] arr) {
		/*
		 * 
		 * In the brute force approach we will look into the 2 loops iteration and for
		 * each loop we will find the a[j] - a[i] and update the max for the same
		 * 
		 */
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					max = Math.max(arr[j] - arr[i], max);
				}
			}
		}
		System.out.println("BuyAndSellStock.brute()");
		System.out.println(max);
	}
}
