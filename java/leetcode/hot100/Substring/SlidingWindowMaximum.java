package hot100.Substring;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast(); // 维护 q 的单调性
            }
            queue.addLast(i);

            // 2. 出
            if (queue.getFirst() <= i - k) { // 队首已经离开窗口了
                queue.removeFirst();
            }

            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
