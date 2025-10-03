package hot100.BinaryTree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class MaxPathSum {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root==null)return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);
        int maxSum=root.val+Math.max(left,0)+Math.max(right,0);
        ans=Math.max(ans,maxSum);
        return root.val+Math.max(Math.max(left,right),0);
    }
}
