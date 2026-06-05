package binary_tree_problesm;

import java.util.Arrays;
import java.util.List;

import static binary_tree_problesm.InvertTree.print;

public class ConstructBT_Inorder_postOrder {
    public static void main(String[] args) {
        List<Integer> in
                = Arrays.asList(4, 8, 2, 5, 1, 6, 3, 7);
        List<Integer> post
                = Arrays.asList(8, 4, 5, 2, 6, 7, 3, 1);

        Tree root = buildTree(in, post);
        print(root);

    }

    private static Tree buildTree(List<Integer> in, List<Integer> post) {
        int n = in.size();
        int[] p_index = new int[1];
        p_index[0] = n - 1;

        return buildUtil(in, post, 0, n - 1, p_index);

    }

    private static Tree buildUtil(List<Integer> in, List<Integer> post, int start, int end, int[] pIndex) {

        if(start > end){
            return null;
        }

        Tree node = new Tree(post.get(pIndex[0]));
        pIndex[0]--;

        if(start == end){
            return node;
        }

        // instead of search make a map of Integer, integer where key = inorder_value & value = index in inorder.
        int inIndex = search(in ,start, end, node.val);

        node.right = buildUtil(in,post,inIndex + 1, end,pIndex);
        node.left = buildUtil(in,post,start, inIndex - 1,pIndex);

        return node;
    }

    static int search(List<Integer> in, int start, int end, int val){
        int i;
        for(i = start; i <= end; i++){
            if(in.get(i) == val)
                break;
        }

        return i;
    }

}
