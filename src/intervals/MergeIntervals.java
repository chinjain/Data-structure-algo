package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {

		/*
		 * 
		 * 1. We will sort the array
		 * 
		 * 2. then we will take the 2nd index value and compare with the prev end with
		 * curr start.
		 * 
		 * 3. if the value of current start is less than value of prev end then we will
		 * store the value in prev end = Math.max(prev end && Current idx end);
		 * 
		 */

		int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] res = mergeIntervals(arr);

		System.out.print(res.length);

	}

	private static int[][] mergeIntervals(int[][] intervals) {
		List<int[]> ans = new ArrayList<int[]>();
		ans.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {

			int currStart = intervals[i][0];

			if (currStart <= ans.get(ans.size() - 1)[1]) {
				ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
			} else {
				ans.add(intervals[i]);
			}

		}

		int[][] res = new int[ans.size()][2];

		ans.toArray(res);

		return res;

	}

}
