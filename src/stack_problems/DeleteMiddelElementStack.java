package stack_problems;

import java.util.Stack;

public class DeleteMiddelElementStack {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(4);
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        System.out.println("Before: " + stack1);
        deleteMiddle(stack1);
        System.out.println("After:  " + stack1);
    }

    private static void deleteMiddle(Stack<Integer> stack1) {
        if(stack1.isEmpty())
            return;
        deleteMiddle(stack1, stack1.size(),0);
    }

    static void deleteMiddle(Stack<Integer> st, int size, int depth){

        if(depth == size / 2){
            st.pop();
            return;
        }

        int top = st.pop();
        deleteMiddle(st, size, depth + 1);
        st.push(top);

    }
}
