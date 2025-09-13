package hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>queue=new LinkedList<>();
        int[][]dirs=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        int round=0;
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                    count++;
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        while (count>0 && !queue.isEmpty()){
            int n=queue.size();
            while (n-->0){
                int[]orange=queue.poll();
                int i=orange[0],j=orange[1];
                for(int[]dir:dirs){
                    int x=i+dir[0],y=j+dir[1];
                    if(get(grid,x,y)==1){
                        grid[x][y]=2;
                        queue.add(new int[]{x,y});
                        count--;
                    }
                }
            }
            round++;
        }

        if(count>0)
            return -1;
        return round;
    }

    public int get(int[][]grid,int i,int j){
        int m=grid.length,n=grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n)
            return 0;
        return grid[i][j];
    }

    public static void main(String[] args) {
        new OrangesRotting().orangesRotting(
                new int[][]{
                        {2,1,1},
                        {1,1,0},
                        {0,1,1}
                });
    }
}
