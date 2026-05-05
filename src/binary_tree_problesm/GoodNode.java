package binary_tree_problesm;

public class GoodNode {
    public static void main(String[] args) {

        Tree root = new Tree(3);
        root.left = new Tree(1);
        root.right = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);


       int goodNodes =  dfs(root, root.val);
       System.out.println(goodNodes);
    }

    public static int dfs(Tree root, int maxSoFar){
        if(root == null)
            return 0;

        int count = 0;

        if(root.val >= maxSoFar){
            count = 1;
        }

        maxSoFar = Math.max(maxSoFar, root.val);

        count += dfs(root.left, maxSoFar);
        count += dfs(root.right, maxSoFar);

        return count;
    }
}
