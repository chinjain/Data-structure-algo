package arrays_problems;

public class StringWeightPalindrome {

    /*
        a = 1
        b = 2
        c = 3
        d = 4
        i.e.

        z = 26

        palindrome abba
        a = 1
        b = 2
        b = 2
        a = 1

        along with
        a = 1
        b = 2
        b = 2
        a = 1
        a = 1
        d = 4

        output should be : 17
     */

    public static void main(String[] args) {

        String s = "abbaad";
        findWeightedPalindromeString(s);
    }

    private static void findWeightedPalindromeString(String s) {
        int total = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            total += expand(s, i, i);

            total += expand(s, i, i+1);
        }
        System.out.println(total);

    }

    private static int expand(String s, int left, int right){
        int sum = 0;
        int weightSum = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
         if(left == right){
             weightSum += Character.toLowerCase(s.charAt(left)) - 'a' + 1;
         }else{
             weightSum += Character.toLowerCase(s.charAt(left)) - 'a' + 1;
             weightSum += Character.toLowerCase(s.charAt(right)) - 'a' + 1;
         }
         sum += weightSum;
         left--;
         right++;
        }

        return sum;
    }
}
