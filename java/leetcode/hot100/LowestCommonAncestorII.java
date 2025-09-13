package hot100;

import java.util.*;

public class LowestCommonAncestorII {
    Map<Integer,TreeNode>parents=new HashMap<>();
    Set<TreeNode>visited=new HashSet<>();
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p);
            p=parents.get(p.val);
        }
        while (q!=null){
            if(visited.contains(q))
                return q;
            q=parents.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root){
        if(root.left!=null){
            parents.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parents.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
