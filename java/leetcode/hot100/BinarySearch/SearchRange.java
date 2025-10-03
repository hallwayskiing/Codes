package hot100.BinarySearch;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)  return new int[]{-1,-1};

        int left = findLeft(nums, target);
        if (left == -1) return new int[]{-1, -1};
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;  // keep the mid because nums[mid] might equal the target
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    // 找最右边界
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2; // plus 1 to ensure moving right
            if (nums[mid] <= target) {
                left = mid;  // // keep the mid because nums[mid] might equal the target
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
