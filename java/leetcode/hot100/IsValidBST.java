package hot100;

public class IsValidBST {
    double val = -Double.MAX_VALUE;
    boolean res=true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root){
        if(root==null)
            return;

        inorder(root.left);
        if(root.val<=val)
            res=false;
        val= root.val;
        inorder(root.right);
    }
}
