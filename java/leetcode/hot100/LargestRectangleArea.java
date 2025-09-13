package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int res=0;

        int[]newHeights=new int[n+2];
        newHeights[0]=0;
        System.arraycopy(heights,0,newHeights,1,n);
        newHeights[n+1]=0;
        n+=2;
        heights=newHeights;

        Deque<Integer>deque=new ArrayDeque<>();
        deque.addLast(0);

        for (int i = 1; i < n; i++) {
            while (heights[i]<heights[deque.peekLast()]){
                int height=heights[deque.removeLast()];
                int width=i-deque.peekLast()-1;
                res=Math.max(res,height*width);
            }
            deque.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
