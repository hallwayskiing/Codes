package hot100;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root){
        invert(root);
        return root;
    }

    public void invert(TreeNode root){
        if(root==null)
            return;
        invert(root.left);
        invert(root.right);

        if(root.left!=null || root.right!=null) {
            TreeNode tmp=root.left;
            root.left=root.right;
            root.right=tmp;
        }
    }
}
