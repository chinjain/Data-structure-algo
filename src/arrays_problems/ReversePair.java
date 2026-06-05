package arrays_problems;


/*

        Count pairs (i,j) where:
         i < j AND nums[i] > 2 × nums[j]
         nums = [1,3,2,3,1]    → 2
         nums = [2,4,3,5,1]    → 3


 */

public class ReversePair {

    public static void main(String[] args) {


        reversePair_brute();
        reversePair_optimal();

    }

    /*
        Key insight:
  During merge sort when merging two halves:
  Left half and right half are already sorted
  Count pairs across left and right efficiently

For each element in left half:
  Count elements in right half
  where nums[left] > 2 × nums[right]

Since both sorted → use two pointer
O(N) per merge → O(N log N) total
     */
    private static void reversePair_optimal() {
        int count = 0;
        int[] nums = {1,3,2,3,1};
        mergeSort(nums, 0, nums.length-1,count);
        System.out.println("Optimal : " + count);

    }

    private static void mergeSort(int[] nums, int left, int right,int count) {
        if(left >= right)
            return;

        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid,count);
        mergeSort(nums, mid + 1, right, count);

        countPair(nums, left, mid, right, count);
        merge(nums, left, mid,right);
    }

    public static void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid)  temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int x = 0; x < temp.length; x++) {
            nums[left+x] = temp[x];
        }

    }

    private static void countPair(int[] nums, int left, int mid, int right, int count) {
        int j = mid+1;

        for(int i = left; i <= mid; i++){
            while (j <= right && nums[i] > 2L * nums[j]){
                j++;
            }

            count += (j - (mid + 1));
        }
    }

    private static void reversePair_brute() {
        int[] num = {1,3,2,3,1};
        int count = 0;

        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                if(num[i] > 2l * num[j]){
                    count++;
                }
            }
        }
        System.out.println("Brute Force : " + count);
    }

}
