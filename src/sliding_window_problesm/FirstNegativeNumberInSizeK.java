package sliding_window_problesm;

import java.util.*;

public class FirstNegativeNumberInSizeK {

    public static void main(String[] args) {

        int [] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < arr.length; i++){
            while (!dq.isEmpty() && dq.peek() < i - k + 1){
                dq.poll();
            }
            
            if(arr[i] < 0){
                dq.addLast(i);
            }

            if(i >= k - 1){
                if(!dq.isEmpty()){
                    res.add(arr[dq.peek()]);
                }else {
                    res.add(0);
                }
            }
        }

        res.forEach(System.out::println);

    }
}
