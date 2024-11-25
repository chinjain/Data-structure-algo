package heap_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqElement {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 6, 6 };
		int k = 3;
		int[] arr = new int[k];

		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			pq.add(entry);

			if (pq.size() > k)
				pq.poll();

		}

		int i = k;

		while (!pq.isEmpty()) {
			arr[--i] = pq.poll().getKey();
		}

		System.out.println(Arrays.toString(arr));

	}

}
