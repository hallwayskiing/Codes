package hot100;

import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {
    TreeNode dummy=new TreeNode(0);
    public void flatten(TreeNode root) {
        if(root==null)
            return;

        dummy.right=root;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=null;
        dummy=dummy.right;

        if(left!=null)
            flatten(left);
        if(right!=null)
            flatten(right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6)));
        new Flatten().flatten(root);
        System.out.println(root);
    }

}
