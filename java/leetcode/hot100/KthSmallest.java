package hot100;

public class KthSmallest {
    int n=0;
    int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }

    public void dfs(TreeNode root,int k){
        if(root==null)
            return;

        dfs(root.left,k);
        if(++n==k)
            ans=root.val;
        dfs(root.right,k);
    }
}

