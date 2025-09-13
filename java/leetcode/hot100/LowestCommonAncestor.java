package hot100;

import java.util.*;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>pathP=dfs(root,p,new ArrayList<>());
        List<TreeNode>pathQ=dfs(root,q,new ArrayList<>());
        int i=0;
        while (i<pathP.size() && i<pathQ.size() && pathP.get(i)==pathQ.get(i))
            i++;
        return pathP.get(i-1);
    }

    public List<TreeNode>dfs(TreeNode root,TreeNode child,List<TreeNode>path){
        if(root==null)
            return null;

        path.add(root);
        if(root==child){
            return new ArrayList<>(path);
        }

        List<TreeNode>left=dfs(root.left,child,path);
        List<TreeNode>right=dfs(root.right,child,path);
        path.remove(path.size()-1);
        return left!=null?left:right;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode left=new TreeNode(5);
        TreeNode right=new TreeNode(1);
        root.left=left;
        root.right=right;
        new LowestCommonAncestor().lowestCommonAncestor(root,left,right);
    }
}
