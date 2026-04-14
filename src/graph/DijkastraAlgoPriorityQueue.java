package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkastraAlgoPriorityQueue {
    public static void main(String[] args) {

        int n = 4;

        //Add edges {node, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new int[]{1, 4});
        adj.get(0).add(new int[]{2, 2});
        adj.get(1).add(new int[]{3, 5});
        adj.get(2).add(new int[]{1, 1});
        adj.get(2).add(new int[]{3, 8});

        int[] result = dijkstra(n, 0, adj);

        System.out.println("Shortest distances from 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("0 → " + i + " = " + result[i]);
        }
    }

    private static int[] dijkstra(int n, int src, List<List<int[]>> adj) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0,src});

        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            if(currDist > dist[currNode])
                continue;

            for(int[] neighbor : adj.get(currNode)){
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = dist[currNode] + edgeWeight;

                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    minHeap.offer(new int[]{newDist, nextNode});
                }
            }

        }

        return dist;
    }
}
