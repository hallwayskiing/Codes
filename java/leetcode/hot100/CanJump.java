package hot100;

public class CanJump {
    public boolean jump(int[]nums){
        int n=nums.length;
        int bound=0;
        for (int i=0;i<n;i++){
            if(i<=bound){
                if(i+nums[i]>=n-1)
                    return true;

                bound=Math.max(bound,i+nums[i]);
            }
            else {
                return false;
            }
        }
        return false;
    }
}
