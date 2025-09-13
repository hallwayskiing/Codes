package hot100;

public class CanJumpII {
    public int jump(int[]nums){
        int n=nums.length;
        int steps=0;
        int bound=0;
        int distance=0;
        for (int i=0;i<n-1;i++){
            distance=Math.max(distance,i+nums[i]);
            if(i==bound){
                steps++;
                bound=distance;
            }
        }
        return steps;
    }
}
