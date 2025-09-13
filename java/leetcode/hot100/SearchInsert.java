package hot100;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return binary(nums,target,0,nums.length-1);
    }

    public int binary(int[]nums,int target,int begin,int end){
        if(begin>end)
            return begin;

        int mid=(begin+end)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            return binary(nums,target,begin,mid-1);
        else return binary(nums,target,mid+1,end);
    }

    public static void main(String[] args) {
        new SearchInsert().searchInsert(new int[]{1,3,5,6},0);
    }
}
