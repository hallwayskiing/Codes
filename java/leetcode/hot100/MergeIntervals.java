package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
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
