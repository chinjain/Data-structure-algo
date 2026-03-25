
public class Queue {

	private int arr[];
	private int start, end, size, maxSize;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		start = -1;
		end = -1;
		size = 0;
	}

	public void push(int element) {
		if (size == maxSize) {
			System.out.println("Queue is full");
			System.exit(1);
		}

		if (end == -1) {
			start = 0;
			end = 0;
		} else {
			this.end = (this.end + 1) % this.maxSize;
			this.arr[this.end] = element;
			size++;
		}
	}

	public int dequeue() {
		if (start == -1) {
			System.out.println("Queue is empty");
			System.exit(1);
		}

		int popped = arr[start];
		if (size == 1) {
			start = -1;
			end = -1;
		} else {
			start = (start + 1) % maxSize;
		}

		size--;
		return popped;
	}

	public static void main(String[] args) {

	}

}
