package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)
            return res;

        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int n=queue.size();
            List<Integer>list=new ArrayList<>();
            while (n-->0){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
