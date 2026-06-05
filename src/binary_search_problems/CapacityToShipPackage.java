package binary_search_problems;


/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i].
Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
It is not allowed to load weight more than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.


 */

public class CapacityToShipPackage {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5};
        int days = 3;

        int l = 0, r = 0, res = 0;

        for(int w : weights){
            l = Math.max(w, l);
            r += w;
        }

        while (l <= r){
            int mid = (l + r)/ 2;
            int day = canShip(weights, mid);

            if(day <= days){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

    private static int canShip(int[] weights, int cap) {
        int load = 0, day = 1;

        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > cap){
                load = weights[i];
                day = day + 1;
            }else {
                load += weights[i];
            }
        }
        return day;
    }
}

