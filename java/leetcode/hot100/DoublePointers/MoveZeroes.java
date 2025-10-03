package hot100.DoublePointers;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i!=i0) {
                    int tmp = nums[i];
                    nums[i] = nums[i0];
                    nums[i0] = tmp;
                }
                i0++;
            }
        }
    }
}
