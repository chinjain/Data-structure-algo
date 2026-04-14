package arrays_problems;

public class BuyAndSellStockMultiTxn {

    public static void main(String[] args) {

        int[] a = {100,182,249,493,50,583,850};

        bruteForcesAlgo(a);
        optimal(a);

    }


    static void optimal(int[] a){

        int sum = 0;

        for(int i = 1; i < a.length; i++){
            if(a[i] > a[i - 1]){
                sum += a[i] - a[i - 1];
            }
        }

        System.out.println(sum);
    }


    private static void bruteForcesAlgo(int[] a) {
        int localMin = a[0];
        int localMax = a[0];
        int res = 0;

        int i = 0;

        while (i < a.length - 1){
            while (i < a.length - 1 && a[i] >= a[i + 1]){
                i++;
            }
            localMin = a[i];

            while (i < a.length - 1 && a[i] <= a[i+1]){
                i++;
            }
            localMax = a[i];

            res += localMax - localMin;
        }

        System.out.println(res);

    }
}
