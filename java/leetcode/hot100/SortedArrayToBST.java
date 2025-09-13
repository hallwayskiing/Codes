package hot100;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;

        if(n==0)
            return null;

        if(n==1)
            return new TreeNode(nums[0]);

        int mid=n/2;

        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,n));
        return root;
    }

    public static void main(String[] args) {
        new SortedArrayToBST().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
