package backtracking_recursion;

public class Permutation_Of_Striing {

	public static void main(String[] args) {

		String s = "ABCD";
		permute(s.toCharArray(), 0);
	}

	private static void permute(char[] chars, int idx) {
		if(idx == chars.length){
			System.out.println(String.valueOf(chars));
			return;
		}

		for(int i = idx; i < chars.length; i++){
			swap(chars,idx, i);
			permute(chars,idx + 1);
			swap(chars,idx, i);
		}
	}

	public static void swap(char[] s, int l, int r) {
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;
	}

}
