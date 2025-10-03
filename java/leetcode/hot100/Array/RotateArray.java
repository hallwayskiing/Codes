package hot100.Array;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            i++;
            j--;
        }
    }
}
