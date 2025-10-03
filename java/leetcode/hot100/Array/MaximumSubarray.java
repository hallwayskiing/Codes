package hot100.Array;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int max=dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}
