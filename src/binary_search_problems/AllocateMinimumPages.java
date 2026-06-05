package binary_search_problems;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        
        brute_minPageAllocation();
        optimal_minPageAllocation();

    }

    private static void optimal_minPageAllocation() {
        int[] books = {12,34,67,90};
        int n = books.length;
        int students = 2;
        int sum = 0;
        int max = 0;

        for(int b : books){
            sum += b;
            max = Math.max(max, b);
        }

        for(int pages = max; pages <= sum; pages++){
            if(canAllocate(books,pages,students)){
                System.out.println(pages);
                break;
            }
        }
    }

    private static boolean canAllocate(int[] books, int maxPages, int students) {
        int count = 1, curr = 0;

        for(int b : books){
            if(curr + b > maxPages){
                count++;
                curr = b;
                if(count > students)
                    return false;
            }else {
                curr += b;
            }
        }
        return true;
    }

    private static void brute_minPageAllocation() {
        int[] books = {12,34,67,90};
        int n = books.length;
        int students = 2;
        int right = 0;
        int left = 0;

        for(int b : books){
            right += b;
            left = Math.max(left, b);
        }

        while (left <= right){
            int mid = (left + right) / 2;

            if(canAllocate(books,mid,students)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
