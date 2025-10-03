package hot100.BinaryTree;

public class DiameterOfBinaryTree {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        search(root);
        return ans;
    }

    private int search(TreeNode root){
        if(root==null)
            return 0;

        int L=search(root.left);
        int R=search(root.right);
        ans=Math.max(ans,L+R);
        return Math.max(L,R)+1;
    }
}
