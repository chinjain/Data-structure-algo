package intervals;

import java.util.Arrays;
import java.util.List;

public class Meeting_Room {

	public static void main(String[] args) {
		
		/*
		 * 
		 * We have a meeting room with time slots 
		 * 
		 * no slot must be overlap with each other if it's overlap then we should return false 
		 * 
		 * else we will return true after iterating all the meetings room time slot.
		 * 
		 */

		Interval i1 = new Interval(9, 15);
		Interval i2 = new Interval(5, 8);
		Interval i3 = new Interval(3, 7);
		List<Interval> intervals = Arrays.asList(i1, i2,i3);

		boolean result = meetingRoom(intervals);
		System.out.println(result);
		
	}

	private static boolean meetingRoom(List<Interval> intervals) {

		intervals.sort((a, b) -> Integer.compare(a.start, b.start));
		
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start < intervals.get(i - 1).end) {
				return false;
			}
		}
		return true;
	}

}

class Interval {

	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

}
