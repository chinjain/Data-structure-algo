package binary_tree_problesm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalOfBt {

    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        List<List<Integer>> result = zigzag_Traversal(root);

    }

    private static List<List<Integer>> zigzag_Traversal(Tree root) {

        List<List<Integer>> result = new ArrayList<>();

        boolean leftToRight = true;

        if(root == null){
            return result;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for(int i = 0; i < size; i++){
                Tree node = queue.poll();

                if(leftToRight){
                    level.addLast(node.val);
                }else {
                    level.addFirst(node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null)
                    queue.add(node.right);
            }

            leftToRight = !leftToRight;
            result.add(level);
        }

        result.forEach(System.out::println);

        return result;
    }
}