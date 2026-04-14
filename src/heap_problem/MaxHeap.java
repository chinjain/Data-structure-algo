package heap_problem;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public static void main(String[] args) {

        MaxHeap max = new MaxHeap(5);

        max.insert(5);
        max.insert(10);
        max.insert(10);
        max.insert(10);
        max.insert(20);
        System.out.println(max.deleteMax());
        System.out.println(max.deleteMax());
        System.out.println(max.deleteMax());
        max.insert(30);
        max.display();

    }


    private int parent(int i){
        return (i - 1)/2;
    }

    private int leftChild(int i){
        return  2 * i + 1;
    }

    private int rightChild(int i){
        return 2*i + 2;
    }

    private boolean hasLeft(int i){
        return leftChild(i) < size;
    }

    private boolean hasRight(int i){
        return rightChild(i) < size;
    }


    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insert(int val){
        if(size == capacity){
            System.out.println("Heap is full");
            return;
        }

        heap[size] = val;
        size++;

        heapifyUp(size - 1);
    }

    void heapifyUp(int i){
        while (i > 0){
            int parent = parent(i);
            if(heap[parent] < heap[i]){
                swap(parent,i);
                i = parent;
            }else {
                break;
            }
        }
    }

    int deleteMax(){
        if(size == 0){
            System.out.println("Heap is empty");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size -1];
        size--;

        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int i) {
        int largest = i;

        if(hasLeft(i) && heap[leftChild(i)] > heap[largest]){
            largest = leftChild(i);
        }

        if(hasRight(i) && heap[rightChild(i)] > heap[largest]){
            largest = rightChild(i);
        }

        if(largest != i){
            swap(largest, i);
            heapifyDown(largest);
        }
    }

    int peekMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    boolean isEmpty() { return size == 0; }
    int size()        { return size; }

    void display() {
        System.out.println("Heap: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }
}
