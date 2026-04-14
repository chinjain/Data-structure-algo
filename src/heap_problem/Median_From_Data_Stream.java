package heap_problem;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_From_Data_Stream {

	static PriorityQueue<Integer> maxHeap;
	static PriorityQueue<Integer> minHeap;

	public Median_From_Data_Stream() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}


	/*
			SO the condition is I will always add the number or stream of data in left and right
			in median middle stream data if the lenght is odd
			so left side of the array will be max and right side will be min
			as we have to maintain the sorted list.
	 */
	public static void addNum(int num) {
		maxHeap.offer(num);

		minHeap.offer(maxHeap.poll());

		if(minHeap.size() > maxHeap.size()){
			maxHeap.offer(minHeap.poll());
		}

	}

	public static double findDataStream() {
			if(maxHeap.size() > minHeap.size()){
				return maxHeap.peek();
			}

		return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}

}
