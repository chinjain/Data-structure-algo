package intervals;

import java.util.ArrayList;
import java.util.Arrays;
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
		final int[] newInterval =  { 4, 9 } ;

		final int res[][] = insertInterval(intervals, newInterval);
		
		System.out.println(Arrays.toString(res));
		
		

	}

	private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<int[]>();
		boolean inserted = false;
		for(int i = 0; i < intervals.length; i++) {
			
			int [] current = intervals[i];
			
			if(inserted || current[1] < newInterval[0]) {
				result.add(current);
			}
			else if(newInterval[1] < current[0]) {
				result.add(newInterval);
				result.add(current);
				inserted = true;
			}else {
				newInterval[0] = Math.min(current[0], newInterval[0]);
				newInterval[1] = Math.max(newInterval[1],current[1]);
			}
			
		}
		
		if(!inserted) {
			result.add(newInterval);
		}
		
		
		return result.toArray(new int[result.size()][2]);
	}

}
