package arrays_problems;

import java.util.Arrays;

public class DuplicateElement {

    public static void main(String[] args) {

        int[] arr = {1,3,4,2,3};

        usingLinkedListCycle(arr);

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i + 1]) {
                System.out.println("Duplicate found :" + arr[i]);
            }
        }

    }

    public static void usingLinkedListCycle(int [] a){
        int slow = a[0];
        int fast = a[0];

        do{
            slow = a[slow];
            fast = a[a[fast]];
        }while (slow != fast);

        fast = a[0];

        while (slow != fast){
            slow = a[slow];
            fast = a[fast];
        }

        System.out.println(slow);
    }
}
