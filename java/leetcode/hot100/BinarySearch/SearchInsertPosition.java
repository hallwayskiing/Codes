package hot100.BinarySearch;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    public int binarySearch(int[] nums, int begin, int end, int target) {
        if(begin>end) return begin;

        int mid = begin + (end - begin) / 2;
        if(nums[mid]==target) return mid;
        else if (nums[mid]>target) return binarySearch(nums,0,mid-1,target);
        else return binarySearch(nums,mid+1,end,target);
    }
}
