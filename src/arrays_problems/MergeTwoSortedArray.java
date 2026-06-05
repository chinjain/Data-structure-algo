package arrays_problems;

/*
        Without extra space
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5, 0, 0, 0};
        int[] num2 = {2, 4, 6};

        int m = 3, n = 3;

        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0){
            if(num1[i] > num2[j]){
                num1[k--] = num1[i--];
            }else{
                num1[k--] = num2[j--];
            }
        }

        while (j >= 0) {
            num1[k--] = num2[j--];
        }

        for(int num : num1){
            System.out.println(num);
        }
    }
}
