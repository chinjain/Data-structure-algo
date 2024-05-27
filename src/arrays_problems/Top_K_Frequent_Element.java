package arrays_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Element {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 2, 2, 3 };

		int[] res = freqElement(arr, 2);

		Arrays.stream(res).forEach(System.out::println);

	}

	private static int[] freqElement(int[] arr, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res[] = new int[k];
		for (int n : arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		int i = k;
		while (!pq.isEmpty()) {
			res[--k] = pq.poll().getValue();
		}
		return res;
	}
}
