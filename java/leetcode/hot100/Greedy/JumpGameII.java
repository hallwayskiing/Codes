package hot100.Greedy;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at index i, you can jump to any index (i + j) where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
 */
public class JumpGameII {
    public int jump(int[] nums){
        int farthest=0,end=0,steps=0;
        for (int i = 0; i < nums.length; i++) {
            farthest=Math.max(farthest,i+nums[i]);
            if(i==end){
                end=farthest;
                steps++;
            }
        }
        return steps;
    }

    public int jumpII(int[] nums) {
        if(nums.length==1) return 0;

        int steps=0;
        int farthest=nums[0];
        int i=0;
        while (farthest<nums.length){
            int temp=farthest;
            for (int j = i; j <= temp; j++) {
                farthest=Math.max(farthest,j+nums[j]);
            }
            steps++;
            i=temp+1;
        }

        return steps;
    }
}
