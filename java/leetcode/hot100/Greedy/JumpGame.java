package hot100.Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest=0;
        for (int i = 0; i < nums.length; i++) {
            if(i<=farthest)
                farthest=Math.max(farthest,i+nums[i]);
            else return false;
        }
        return true;
    }
}
