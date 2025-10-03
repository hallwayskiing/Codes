package hot100.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]>list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int begin=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int front=intervals[i][0],rear=intervals[i][1];
            if(front<=end && front>=begin){
                end=Math.max(end,rear);
                continue;
            }
            list.add(new int[]{begin,end});
            begin=front;
            end=rear;
        }
        list.add(new int[]{begin,end});

        int[][]res=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][]intervals=new int[][]{{1,3},{2,6}};
        new MergeIntervals().merge(intervals);
    }
}
