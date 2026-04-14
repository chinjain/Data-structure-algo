package stack_problems;

public class Implement_Queue_using_Array {

	public static void main(String[] args) {
		Queue queue = new Queue(4);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);


		System.out.println("Front: " + queue.peek());
		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Front after dequeue: " + queue.peek());
	}

	static class Queue{
		int front;
		int rear;
		int[] arr;
		int capacity;
		int size;

		Queue(int capacity){
			this.capacity = capacity;
			arr = new int[capacity];
			front = 0;
			rear = -1;
			size = 0;
		}

		void enqueue(int x){
			if(isFull()){
				System.out.println("Queue is Full");
				return;
			}
			arr[++rear] = x;
			size++;
		}

		int dequeue(){
			if(isEmpty()){
				System.out.println("Queue is Empty");
				return -1;
			}
			size--;
			return arr[front++];
		}

		int peek(){
			if(isEmpty()){
				System.out.println("Queue is Empty");
				return -1;
			}

			return arr[front];
		}

		boolean isFull(){
			return rear == capacity - 1;
		}

		boolean isEmpty(){
			return size == 0;
		}

		int size(){
			return size;
		}
	}

}
