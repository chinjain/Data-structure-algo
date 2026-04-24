package greedy;

import java.util.Arrays;

public class JobSchedulingProblem {

    public static void main(String[] args) {

        Job[] jobs = new Job[]{
          new Job(1,4,20),
          new Job(2,1,10),
          new Job(3,1,40),
          new Job(4,1,30)
        };

        int[] ans = jobScheduling(jobs);
        System.out.println(Arrays.toString(ans));

    }

    private static int[] jobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (a,b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for(Job job : jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int countJobs = 0;
        int totalProfit = 0;

        for(Job job : jobs){
            for(int j = job.deadline; j > 0; j--){
                if(slots[j] == -1){
                    slots[j] = job.id;
                    countJobs++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, totalProfit};
    }


    static class Job{
        private int id;
        private int deadline;
        private int profit;

        public Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}


