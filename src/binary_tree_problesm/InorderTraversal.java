package binary_tree_problesm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {

        Tree root = new Tree(4);
        root.left  = new Tree(2);
        root.right = new Tree(6);
        root.left.left   = new Tree(1);
        root.left.right  = new Tree(3);
        root.right.left  = new Tree(5);
        root.right.right = new Tree(7);

        System.out.println("Iterative: " + inorderIterative(root));

    }

    static List<Integer> inorderIterative(Tree root) {
        List<Integer> result = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        Tree curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}
