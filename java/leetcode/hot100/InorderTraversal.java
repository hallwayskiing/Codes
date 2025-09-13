package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        inorder(root,res);
        return res;
    }

    void inorder(TreeNode root,List<Integer>list){
        if(root==null)
            return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
