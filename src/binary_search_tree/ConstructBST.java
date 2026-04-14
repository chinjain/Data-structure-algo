package binary_search_tree;

import binary_tree_problesm.Tree;

public class ConstructBST {
    public static void main(String[] args) {
    }

    Tree insert(Tree root, int val) {
        if (root == null) return new Tree(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    Tree constructBst(int[] keys){
        Tree root = null;

        for(int val : keys){
            root = insert(root,val);
        }

        return root;
    }

    Tree constructBstOptimal(int[] keys){
        if(keys.length == 0)
            return null;

        Tree root = new Tree(keys[0]);

        for(int i = 1; i < keys.length; i++){
            Tree curr = root;
            Tree parent = null;

            while (curr != null){
                parent = curr;
                if(keys[i] < curr.val){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }

                if(keys[i] < parent.val){
                    parent.left = new Tree(keys[i]);
                }else{
                    parent.right = new Tree(keys[i]);
                }
            }
        }

        return root;
    }

}
