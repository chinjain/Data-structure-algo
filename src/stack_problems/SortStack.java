package stack_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);

//        System.out.println("Before: " + stack);
//        sortStack(stack);
//        System.out.println("After:  " + stack);

        System.out.println("Before: " + stack);
        optimalSort(stack);
        System.out.println("After:  " + stack);
    }

    private static void optimalSort(Stack<Integer> stack) {

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()){
            int element = stack.pop();

            while (!temp.isEmpty() && temp.peek() > element){
                stack.push(temp.pop());
            }
            temp.push(element);
        }

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    private static void sortStack(Stack<Integer> stack) {
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        Collections.sort(list);

        for(int i = list.size() - 1; i >= 0; i--){
            stack.push(list.get(i));
        }

    }
}
