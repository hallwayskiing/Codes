package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n= queue.size();
            int num=0;
            while (n-->0){
                TreeNode node=queue.poll();
                num=node.val;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            res.add(num);
        }
        return res;
    }
}
