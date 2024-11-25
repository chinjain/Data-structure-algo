package sliding_window_problesm;

import java.util.HashMap;

public class LargestSubaarrayWithEqual01 {

	public static void main(String[] args) {

		int arr[] = {1, 0, 0, 1, 0, 1, 1};
		bruteforce(arr,arr.length);
		
		optimal(arr,arr.length);
		
		
	}

	private static void optimal(int[] arr, int length) {
		
		/*
		 * This problem replicate the longest subarray with 0 sum 
		 * 
		 * We will go with the appraoch of PrefixSum & Hashmap
		 * 
		 */
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int sum = 0;
		
		int maxLen = 0;
		
		for(int i = 0; i < length; i++) {
			
			sum += (arr[i] == 0) ? -1 : 1;
			
			if(sum == 0)
				maxLen = i + 1;
			
			if(hm.containsKey(sum)) {
				maxLen = Math.max(maxLen, i - hm.get(sum));
			}else {
				hm.put(i, sum);
			}
		}
		
		System.out.println("Max-lenght : {}" + maxLen);
	}

	private static void bruteforce(int[] arr, int length) {
		
		int sum = 0;
		int maxSize = -1, startIdx = 0;
		int endIdx = 0;
		
		for(int i = 0; i < length-1; i++) {
			
			sum = (arr[i] == 0) ? -1 : 1;
			
			for(int j = i+1; j < length; j++) {
				if(arr[j] == 0) {
					sum += -1;
				}else {
					sum += 1;
				}
			
				if(sum == 0 && maxSize < j - i + 1) {
					maxSize = j-i+1;
					startIdx = i;
				}
			}
			
			
		}
		
		endIdx = startIdx + maxSize - 1;
		if(maxSize == -1)
			System.out.println("No such arrays");
		else
			System.err.println(startIdx + " to " + endIdx);
		}
	}
	