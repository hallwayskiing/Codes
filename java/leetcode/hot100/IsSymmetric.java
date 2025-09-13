package hot100;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {
        public boolean isSymmetric(TreeNode root) {
            if(root==null)
                return true;

            return compare(root.left,root.right);
        }

        private boolean compare(TreeNode left,TreeNode right){
            if(left==null && right==null) {
                return true;
            }
            if(left==null || right==null) {
                return false;
            }
            if(left.val!=right.val) {
                return false;
            }

            return compare(left.left,right.right) && compare(left.right,right.left);
        }
}
