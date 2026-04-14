package stack_problems;

import java.util.Arrays;

public class Impl_StackUsingArray {

    public static void main(String[] args) {

        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(40);
        stack.push(40);
        stack.push(40);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size:  " + stack.size());


        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Top element after pops: " + stack.peek());
        System.out.println("Is empty: " + stack.isEmpty());


    }


    static class Stack{
        int [] arr;
        int top;
        int capacity;

        Stack(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1; // empty stack
        }

        void push(int x){
            if(isFull()){
                // resize as per the use case as we will have the memory and we don't want our user to give overflow
               resize();
            }
            arr[++top] = x;
        }

        int pop(){
            if(isEmpty()){
                System.out.println("Stack Underflow — stack is empty");
                return -1;
            }

            return arr[top--];
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[top];
        }

        public boolean isFull(){
            return  top == capacity - 1;
        }

        public boolean isEmpty(){
            return top == -1;
        }

        int size() {
            return top + 1;
        }

        void resize(){
            capacity = capacity * 2;
            arr = Arrays.copyOf(arr,capacity);
            System.out.println("Stack resized to capacity: " + capacity);
        }

    }
}
