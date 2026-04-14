package stack_problems;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        int[] a = {4, 5, 2, 10, 8};

        int[] result = new int[a.length];

        for(int i = 0; i < a.length; i++){
            result[i] = -1;

            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[i]){
                    result[i] = a[j];
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(result));

        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < a.length; i++){

            while (!st.isEmpty() && a[st.peek()] > a[i]){
                int idx = st.pop();
                res[idx] = a[i];
            }

            st.push(i);
        }

        System.out.println(Arrays.toString(res));
    }
}
