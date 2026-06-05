package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountTotalPathInDag {

    public static void main(String[] args) {
        int V = 4;
        int src = 2, dest = 3;
        int[][] edges = { {0,1}, {0,3}, {2,0}, {2,1}, {1,3}};
        System.out.println(countPaths_bfs(edges, V, src, dest));
    }

    private static int countPaths_bfs(int[][] edges, int v, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[v];
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }

        int[] paths = new int[v];
        paths[src] = 1;

        while (!q.isEmpty()){
            int u = q.poll();

            for(int neighbour : adj.get(u)){
                paths[neighbour] += paths[u];
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return paths[dest];
    }
}
