package sliding_window_problesm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingStream {
    public static void main(String[] args) {
        String str = "aabcb";

        char[] input = str.toCharArray();
        Map<Character,Integer> freq = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for(char c : input){
            freq.put(c, freq.getOrDefault(c,0) + 1);

            q.add(c);

            while (!q.isEmpty() && freq.get(c) > 1){
                q.poll();
            }

            if(!q.isEmpty()){
                System.out.println(q.peek() + " ");
            }else{
                System.out.println(-1 + " ");
            }
        }
    }
}
