package hot100.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if(map.containsKey(target-num)){
                return new int[]{i,map.get(target-num)};
            }
            map.put(num,i);
        }
        return null;
    }


    public int partition(int[]nums, int begin, int end){
        int pivot=nums[begin];
        int left=begin,right=end;
        while (left<right){
            while (left<right && nums[right]>=pivot)
                right--;
            nums[left]=nums[right];

            while (left<right && nums[left]<=pivot)
                left++;
            nums[right]=nums[left];
        }

        nums[left]=pivot;
        return left;
    }

    public void quickSort(int[]nums,int begin,int end){
        if(begin>=end)
            return;

        int mid=partition(nums,begin,end);
        quickSort(nums,begin,mid-1);
        quickSort(nums,mid+1,end);
    }
}


