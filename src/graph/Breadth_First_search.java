package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Breadth_First_search {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(4);
		adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);

		List<Integer> ans = bfs(5, adj);
		
		ans.stream().forEach(System.out::println);

	}

	private static List<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj) {
		List<Integer> bsf = new ArrayList<Integer>();
		boolean[] visit = new boolean[v];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		visit[0] = true;

		while (!q.isEmpty()) {
			int node = q.poll();
			bsf.add(node);

			for (int it : adj.get(node)) {
				if (visit[it] == false) {
					q.add(it);
					visit[it] = true;
				}
			}
		}

		return bsf;
	}

}
