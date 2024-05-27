package intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	/* 
	 * I have to insert the new interval in existing one and maintain the non
	 * overlap interval
	 *
	 * toh hoga kya check krana padegaa dono end if the end of idx - 1 < start new
	 * Interval merge them
	 * 
	 */

	public static void main(final String[] args) {
		final int[][] intervals = { { 1, 3 }, { 5, 7 }, { 8, 10 }, { 11, 12 } };
		final int[][] newInterval = { { 4, 9 } };

		final int res[][] = insertInterval(intervals, newInterval);

	}

	private static int[][] insertInterval(int[][] intervals, int[][] newInterval) {
		List<int[]> result = new ArrayList<int[]>();

		int i = 0;
		result.add(intervals[0]);

		while (i < intervals.length && intervals[i][1] < newInterval[0][0]) {
			result.add(intervals[i++]);
		}

		return null;
	}

}
