package hot100.DoublePointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;

        Arrays.sort(nums);
        for (int i=0;i<n;i++){
            //由于已经排序，当前数字大于0时，三数和一定大于0，直接退出循环
            if(nums[i]>0)
                break;

            //重复数字跳过
            if(i>0 && nums[i]==nums[i-1])
                continue;

            int left=i+1;
            int right=n-1;
            while (left<right) {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    //去重
                    while (left<right && nums[left]==nums[left+1])
                        left++;
                    while (left<right && nums[right]==nums[right-1])
                        right--;

                    left++;
                    right--;
                }
                else if(sum<0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
