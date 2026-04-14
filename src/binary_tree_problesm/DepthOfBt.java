package binary_tree_problesm;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBt {

    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left  = new Tree(9);
        root.right = new Tree(20);
        root.right.left  = new Tree(15);
        root.right.right = new Tree(7);

        bfs(root);

        System.out.println("Max Depth: " + maxDepth(root)); // 3

        System.out.println(maxDepth(null));            // 0
        System.out.println(maxDepth(new Tree(1))); // 1
    }

    static int maxDepth(Tree root){

        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);


        return 1 + Math.max(left, right);
    }

    static void bfs(Tree root){
        System.out.print("BFS");

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()){
           int size = q.size();
           depth++;

           for(int i = 0; i < size; i++){
               Tree node = q.poll();
               if(node.left != null) q.add(node.left);
               if(node.right != null) q.add(node.right);
           }
        }

        System.out.println(depth);
    }
}
