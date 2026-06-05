package graph;

import java.util.Arrays;

public class BellManFord_Algo {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] edges1 = {
                {0,1,4}, {0,2,5},
                {1,2,-3},{1,3,6},
                {2,4,2}, {3,4,3}
        };

        int[] result1 = bellmanFord(n1, 0, edges1);
        System.out.println(Arrays.toString(result1));
    }

    private static int[] bellmanFord(int n, int src, int[][] edges) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i < n; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }

            for (int[] edge : edges) {
                int u      = edge[0];
                int v      = edge[1];
                int weight = edge[2];

                if (dist[u] != Integer.MAX_VALUE
                        && dist[u] + weight < dist[v]) {
                    System.out.println(" negative Cycle detected");
                    return null;
                }
            }
        }
        return dist;
    }
}
