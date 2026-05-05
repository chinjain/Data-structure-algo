package strings_problem;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringsKDistinct {

    public static void main(String[] args) {

        String s = "abcba";
        int k = 2;
//        bruteforce(s, k);

        Map<Character,Integer> freqMap = new HashMap<>();
        int j = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            freqMap.put(s.charAt(i),freqMap.getOrDefault(s.charAt(i),0) + 1);

            while (freqMap.size() > k){
                char c = s.charAt(j);
                if(freqMap.get(c) == 1)
                    freqMap.remove(c);
                else {
                    freqMap.put(c, freqMap.get(c) - 1);
                }
                j++;
            }

            ans += i - j ;
            System.out.println(s.substring(j, i + 1));
        }

        System.out.println(ans);

    }

    static void bruteforce(String s, int k){

        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            Map<Character, Integer> map = new HashMap<>();

            for(int j = i; j < n; j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);

                if(map.size() == k){
                    cnt += j - i;
                    System.out.println(s.substring(i, j + 1));
                }else if (map.size() > k){
                    break;
                }
            }
        }

        System.out.println(cnt);
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
