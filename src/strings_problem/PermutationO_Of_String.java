package strings_problem;

public class PermutationO_Of_String {

	public static void main(String[] args) {


		System.out.println("Optimal Solutions");
		String s1 = "eid";
		String s2 = "eidbaooo";

		if(s1.length() > s2.length())
			System.out.println("FALSE");

		int[] need = new int[26];
		int[] window = new int[26];

		for(char c : s1.toCharArray()){
			need[c - 'a']++;
		}

		int k = s1.length();
		boolean isMatch = false;
		for(int right = 0; right < s2.length(); right++){
			window[s2.charAt(right) - 'a']++;

			if(right >= k){
				window[s2.charAt(right - k) - 'a']--;
			}

			if(match(window,need)){
				isMatch = true;
				System.out.println("TRUE");
			}
		}

		if(!isMatch){
			System.out.println("FALSE");
		}
		
	}

	static boolean match(int[] inp1, int[] inp2){
		for(int i = 0; i < 26; i++){
			if(inp1[i] != inp2[i])
				return false;
		}

		return true;
	}

}
