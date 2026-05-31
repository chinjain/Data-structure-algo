package greedy;

import java.util.Arrays;

public class FractionalKnapsack {

    static class Item{
        int weight;
        int value;
        double ratio;

        Item(int weight, int value) {
            this.weight = weight;
            this.value  = value;
            this.ratio  = (double) value / weight;
        }
    }


    public static void main(String[] args) {
        int[] weights1 = {2, 3, 5, 7};
        int[] values1  = {10, 15, 20, 21};

        double result1 = fractionalKnapsack(10, weights1, values1);
        System.out.println("Max Value = " + result1);

        System.out.println();

        int[] weights2 = {10, 20, 30};
        int[] values2  = {60, 100, 120};
        System.out.println("=== Test 2 ===");
        double result2 = fractionalKnapsack(50, weights2, values2);
        System.out.println("Max Value = " + result2);
    }

    static double fractionalKnapsack(int capacity, int[] weights, int[] values){
        int n = weights.length;

        Item[] items = new Item[n];

        for(int i = 0; i < n; i++){
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, (a,b) -> Double.compare(b.ratio,a.ratio));

        double totalValue = 0;
        int remaining = capacity;

        for(Item item : items){
            if(remaining == 0)
                break;

            if(item.weight <= remaining){
                totalValue += item.value;
                remaining -= item.weight;
            }else{
                double fraction =(double)remaining / item.weight;
                totalValue += item.value * fraction;
                remaining = 0;
            }
        }

        return totalValue;
    }
}
