package sliding_window_problesm;

public class MaxVowelInAStringOfK {

    public static void main(String[] args) {


        int k = 3;
        System.out.println("Testcase 1 : " + optimal("abciiidef",3));

    }


    /*
        TimeComplexity : O(n X K);
     */
    static int bruteForce(String s, int k){
        int count = 0;

        for(int i = 0; i <= s.length() - k; i++){
            int vowel = 0;
            for(int j = i; j < i + k; j++){
                if(isVowel(s.charAt(j)))
                    vowel++;
            }
            count = Math.max(count, vowel);
        }

        return count;

    }


    static int optimal(String str, int k){
        int n = str.length();
        int max = 0;

        for(int i = 0; i < k; i++){
            if(isVowel(str.charAt(i))) max++;
        }

        int maxCount = max;

        for(int r = k; r < n; r++){
            int left = r - k;

            if(isVowel(str.charAt(r))) max++;

            if(isVowel(str.charAt(left))) max --;


            maxCount = Math.max(maxCount,max);
        }

        return maxCount;
    }


    static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}

