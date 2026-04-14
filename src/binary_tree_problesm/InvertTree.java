package binary_tree_problesm;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public static void main(String[] args) {
        Tree root = new Tree(4);
        root.left  = new Tree(2);
        root.right = new Tree(7);
        root.left.left   = new Tree(1);
        root.left.right  = new Tree(3);
        root.right.left  = new Tree(6);
        root.right.right = new Tree(9);

        System.out.print("Before: ");
        print(root);

        invertTree(root);

        print(root);

    }

    static Tree invertTree(Tree root){
        Queue<Tree> nodes = new LinkedList<>();

        nodes.add(root);

        while (!nodes.isEmpty()){

            Tree node = nodes.poll();

            Tree temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) nodes.add(node.left);
            if(node.right != null) nodes.add(node.right);
        }

        return root;
    }

    static void print(Tree root) {
        if (root == null) return;
        java.util.Queue<Tree> q = new java.util.LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree node = q.poll();
            System.out.print(node.val + " ");
            if (node.left  != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        System.out.println();
    }
}
