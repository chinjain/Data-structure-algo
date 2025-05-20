package strings_problem;

import java.util.HashMap;
import java.util.Map;

public class CountSubstrinWithKDisitinc {

    public static void main(String[] args) {

        String s = "abcbabjcbdas";
        int k = 4;

        countString(s, k);

    }

    static  void countString(String s, int k){

        int left = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k){
                char atLeft = s.charAt(left);
                map.put(atLeft, map.get(atLeft) - 1);

                if(map.get(atLeft) == 0){
                    map.remove(atLeft);
                }
                left++;
            }

            count += (right - left);

        }

        System.out.println(count);

    }
}
