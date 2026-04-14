package graph;

/*
A province is a group of cities where you can travel from any city to any other city in that group — directly or indirectly.
Example:

City 1 connects to City 2
City 2 connects to City 3
City 4 is alone — no connection to anyone

So we have 2 provinces:

Province 1 → City 1, City 2, City 3
Province 2 → City 4

Your job — count how many such provinces exist.
This is nothing but counting connected components in a graph.
 */


// TC => O(N) for the traversal if all the component are disconnected

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println("Number of Provinces: " + findCircleNum(isConnected));
    }

    static int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
//                dfs(i,isConnected, visited, n);
                bfs(i,isConnected, visited, n);
                provinces++;
            }
        }
        System.out.println(provinces);
        return provinces;
    }

    static void bfs(int start, int[][] isConnected, boolean[] visisted, int n){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visisted[start] = true;

        while (!q.isEmpty()){
            int node = q.poll();

            for(int neighbour = 0; neighbour < n; neighbour++){
                if(isConnected[node][neighbour] == 1 && !visisted[neighbour]){
                    q.add(neighbour);
                    visisted[neighbour] = true;
                }
            }
        }
    }

    static void dfs(int start, int[][] isConnected, boolean[] visit, int n){
        visit[start] = true;

        for(int neighbour = 0; neighbour < n; neighbour++){
            if(isConnected[start][neighbour] == 1 && !visit[neighbour]){
                dfs(neighbour,isConnected,visit,n);
            }
        }
    }
}
