package heap_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class K_CLosest_point {

	public static void main(String[] args) {

		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;

		kClosestPoint(points, k);

		// formula of euclidean dist -> math.sqrt( (x1 - x2)^2 + (y1-y2)^2);
	}

	private static void kClosestPoint(int[][] points, int k) {

		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

		for (int[] point : points) {

			pq.add(point);
			if (pq.size() > k) {
				pq.poll();
			}

		}

		List<int[]> list = new ArrayList<int[]>(k);
		for (int i = 0; i < k; i++) {
			int[] val = pq.poll();
			list.add(val);
		}

		for (int[] a : list) {
			System.out.println(a[0] + ":" + a[1]);
		}
	}

}
