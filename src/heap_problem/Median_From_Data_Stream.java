package heap_problem;

import java.util.PriorityQueue;

public class Median_From_Data_Stream {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	public Median_From_Data_Stream() {
		maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
	}

	public static void main(String[] args) {

	}

	public static void addNum(int num) {

	}

	public static double getMedian() {
		return 0.0;
	}

}
