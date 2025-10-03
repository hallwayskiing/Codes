package hot100.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int heapSize=nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2;
        int largest = i;
        if (left < heapSize && nums[largest] < nums[left]) largest = left;
        if (right < heapSize && nums[largest] < nums[right]) largest = right;
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int findKthLargestII(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) queue.add(num);
        for (int i = 0; i < k - 1; i++) queue.poll();
        return queue.poll();
    }

    public int findKthLargestIII(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int begin, int end, int k) {
        if (begin == end) return nums[k];

        int pivot = nums[begin];
        int left = begin, right = end;
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        if (k <= right) return quickSelect(nums, begin, right, k);
        else return quickSelect(nums, right + 1, end, k);
    }
}
