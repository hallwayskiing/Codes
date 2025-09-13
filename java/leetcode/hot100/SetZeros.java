package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int row= matrix.length;
        int col=matrix[0].length;
        Set<Integer> rowSet=new HashSet<>();
        Set<Integer> colSet=new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num=matrix[i][j];
                if(num==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (Integer i:rowSet) {
            for (int j = 0; j < col; j++) {
                matrix[i][j]=0;
            }
        }

        for (Integer i:colSet) {
            for (int j = 0; j < row; j++) {
                matrix[j][i]=0;
            }
        }
    }
}
