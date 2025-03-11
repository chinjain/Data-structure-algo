package strings_problem;

public class First_Non_Repeating_Character {

	public static final int MAX_FREQ = 26;

	public static void main(String[] args) {
		
		String str = "racecar";

		naiveApproach(str,str.length()); // Time complexity is O(n^2);
		frequency_array(str,str.length());

	}

	private static void frequency_array(String str, int length) {

		int [] freq = new int[MAX_FREQ];
		for(char c : str.toCharArray()){
			freq[c - 'a']++;
		}

		for(int i = 0; i < str.length(); i++){

			if(freq[str.charAt(i) - 'a'] == 1){
				System.out.println(str.charAt(i));
				break;
			}

		}


	}

	private static void naiveApproach(String str, int length) {

		for(int i = 0; i < length; i++){
			boolean found = false;

			for(int j = 0; j < length; j++){

				if(i != j && str.charAt(i) == str.charAt(j)){
					found = true;
					break;
				}
			}
			if(!found){
				System.out.println(str.charAt(i));
				break;
			}
		}

		System.out.println(" ");

	}

}
