package greedy;

import java.util.Arrays;

public class MinPlatformRequiredForTrains {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910,1200,1120,1130,1900,2000};

        int maxPlatforms = Integer.MIN_VALUE;


        for(int i = 0; i < arr.length; i++){
            int platform = 1;

            for(int j = i+1; j < arr.length; j++){

                if(arr[i] <= dep[j] && arr[j] <= dep[i])
                    platform++;
            }
            maxPlatforms = Math.max(maxPlatforms, platform);
        }

        System.out.println(maxPlatforms);


        System.out.println("Optimal Solutions");

        findPlatformsOptimal(arr,dep,arr.length);
    }

    private static void findPlatformsOptimal(int[] arr, int[] dep, int length) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int platform = 0;
        int maxPlatform = 0;

        while (i < length && j < length){
            if(arr[i] < dep[j]){
                platform++;
                maxPlatform = Math.max(platform, maxPlatform);
                i++;
            }else{
                platform--;
                j++;
            }
        }

        System.out.println(maxPlatform);

    }
}
