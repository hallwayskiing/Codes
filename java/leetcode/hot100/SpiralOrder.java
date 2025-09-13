package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list=new ArrayList<>();
        int row= matrix.length,col=matrix[0].length;
        int[][]directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int i=0,j=0;
        int left=0,right=col-1,up=0,down=row-1;
        int dir=0;
        //第3次换方向时，上边界变窄，第4次右边界变窄，以此类推
        while (j>=(left+(dir-2)/4) && j<=(right-(dir)/4) && i>=(up+(dir+1)/4) && i<=(down-(dir-1)/4)){
            while (j>=(left+(dir-2)/4) && j<=(right-(dir)/4) && i>=(up+(dir+1)/4) && i<=(down-(dir-1)/4)){
                list.add(matrix[i][j]);
                i+=directions[dir%4][0];
                j+=directions[dir%4][1];
            }
            //越界后退回界内
            i-=directions[dir%4][0];
            j-=directions[dir%4][1];
            dir++;
            //改变方向后前进一格
            i+=directions[dir%4][0];
            j+=directions[dir%4][1];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][]matrix=new int[][]{{1,2,3,4,6},{2,5,6,7,8},};
        new SpiralOrder().spiralOrder(matrix);
    }
}
