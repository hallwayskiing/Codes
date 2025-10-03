package hot100.Heap;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        int n = freq.size();
        Map.Entry<Integer, Integer>[] set = freq.entrySet().toArray(new Map.Entry[0]);

        int[][] heap = new int[k][2];
        int heapSize = 0;
        for (int i = 0; i < n; i++) {
            if (heapSize < k) {
                heap[heapSize][0] = set[i].getKey();
                heap[heapSize][1] = set[i].getValue();
                heapSize++;
                siftUp(heap,heapSize-1);
            } else {
                if (set[i].getValue() > heap[0][1]) {
                    heap[0][0] = set[i].getKey();
                    heap[0][1] = set[i].getValue();
                    siftDown(heap, 0, heapSize);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap[i][0];
        }
        return res;
    }

    public void buildMinHeap(int[][] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, heapSize);
        }
    }

    public void siftDown(int[][] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2;
        int min = i;
        if (left < heapSize && nums[left][1] < nums[min][1]) min = left;
        if (right < heapSize && nums[right][1] < nums[min][1]) min = right;
        if (min != i) {
            swap(nums, i, min);
            siftDown(nums, min, heapSize);
        }
    }

    public void siftUp(int[][] heap, int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent][1] <= heap[i][1]) break;
            swap(heap, parent, i);
            i = parent;
        }
    }

    public void swap(int[][] nums, int i, int j) {
        int tempKey = nums[i][0];
        int tempVal = nums[i][1];
        nums[i][0] = nums[j][0];
        nums[i][1] = nums[j][1];
        nums[j][0] = tempKey;
        nums[j][1] = tempVal;
    }
}
