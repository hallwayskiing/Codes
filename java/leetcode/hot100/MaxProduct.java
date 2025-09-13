package hot100;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[]dpMax=new int[n];
        int[]dpMin=new int[n];
        dpMax[0]=dpMin[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(nums[i], dpMax[i - 1] * nums[i]));
            max=Math.max(max,dpMax[i]);
        }

        return max;
    }
}
