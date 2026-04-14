package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDfs {
    public static void main(String[] args) {

        int n1 = 7;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i <= n1; i++)
            adj1.add(new ArrayList<>());

        adj1.get(1).add(2); adj1.get(2).add(1);
        adj1.get(2).add(3); adj1.get(3).add(2);

        // Component 2
        adj1.get(4).add(5); adj1.get(5).add(4);
        adj1.get(5).add(6); adj1.get(6).add(5);
        adj1.get(6).add(7); adj1.get(7).add(6);
        adj1.get(7).add(4); adj1.get(4).add(7);

        System.out.println("Graph 1 has cycle: " + hasAnyCycle(n1, adj1));

    }

    static boolean hasAnyCycle(int n, List<List<Integer>> adj) {
        boolean[] visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                if (isCycle(i, n, adj, visit, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isCycle(int start, int n, List<List<Integer>> adj, boolean[] visit, int parent){
        visit[start] = true;

        for(int neighbour : adj.get(start)){
            if(visit[neighbour] && neighbour != parent){
                return true;
            }else if(!visit[neighbour]){
                if(isCycle(neighbour,n,adj,visit,start)){
                    return true;
                }
            }
        }
        return false;
    }
}
