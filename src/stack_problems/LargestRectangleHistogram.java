package stack_problems;

import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        int[] h = {2,4,5,7,7,7,7,7,7,9,9,9,8,8,7,8,2,0,4};
//        largestRectangleArea(h);
        optimal(h);
    }


    public static int largestRectangleArea(int[] h) {

        int maxArea = 0;

        for(int i = 0; i < h.length; i++){
            int height = h[i];
            int l = i;
            int r = i;

            while (l >= 0 && height <= h[l]) l--;

            while (r < h.length - 1 && height <= h[r]) r++;

            int width = r - l - 1;
            maxArea = Math.max(maxArea, width * height);
        }


        System.out.println("Max Area of rectangle is : "+ maxArea);
        return maxArea;

    }

    public static void optimal(int[] h){
        int[] rb = new int[h.length];
        int[] lb = new int[h.length];
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();
        st.push(h.length - 1);

        rb[h.length - 1] = h.length;

        //approach will follow the next smaller to left

        for(int i = h.length - 2; i >= 0; i--){
            while (!st.isEmpty() &&  h[i] <= h[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rb[i] = h.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        // next smaller to right
        lb[0] = -1;
        st.clear();
        st.push(0);

        for(int i = 1; i < h.length; i++){
            while (!st.isEmpty() && h[i] <= h[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0; i < h.length; i++){
            int width = rb[i] - lb[i] - 1;
            maxArea = Math.max(maxArea, width * h[i]);
        }

        System.out.println("Optimal approach max Area : " + maxArea);
    }

}
