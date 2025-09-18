package hot100;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                int tmp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = tmp;
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int tmp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = tmp;
                right--;
            }
        }
    }

    public void sortColorsII(int[] nums) {
        int n = nums.length;

        quickSort(nums, 0, n - 1);
    }

    public int partition(int[] nums, int begin, int end) {
        int pivot = nums[begin];
        int left = begin, right = end;

        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        return left;
    }

    public void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int mid = partition(nums, begin, end);
            quickSort(nums, begin, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }
}
