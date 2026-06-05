package binary_tree_problesm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);


        List<Integer> result = boundaryTraversal(root);
        System.out.println(result);

    }

    private static List<Integer> boundaryTraversal(Tree root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        if(!isLeaf(root)){
            res.add(root.val);
        }

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;

    }

    private static void addRightBoundary(Tree root, List<Integer> res) {
        Tree curr = root.right;
        List<Integer> temp = new ArrayList<>();

        while (curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.val);
            }

            if(curr.right != null){
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }

        Collections.reverse(temp);
        res.addAll(temp);
    }

    private static void addLeaves(Tree root, List<Integer> res) {

        if(isLeaf(root)){
            res.add(root.val);
        }

        if(root.left != null){
            addLeaves(root.left, res);
        }

        if(root.right != null)
            addLeaves(root.right, res);
    }

    private static void addLeftBoundary(Tree root, List<Integer> res) {
        Tree curr = root.left;

        while (curr != null){
            if(!isLeaf(curr))
                res.add(curr.val);

            if(curr.left != null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
    }

    private static boolean isLeaf(Tree root) {
        return root.left == null && root.right == null;
    }


    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
