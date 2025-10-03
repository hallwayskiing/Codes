package hot100.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // borders
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // iterate top border
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // iterate right border
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // iterate bottom border
            // check to avoid duplicate
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // iterate left border
            // check to avoid duplicate
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public List<Integer> spiralOrderII(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0;
        //border
        int left = 0, right = col - 1, up = 0, down = row - 1;
        //times that direction changed
        int dir = 0;
        //when dir==3,up+1;when dir==4,right-1;when dir==5,down-1;when dir==6,left+1;so on.
        while (j >= (left + (dir - 2) / 4) && j <= (right - (dir) / 4) && i >= (up + (dir + 1) / 4) && i <= (down - (dir - 1) / 4)) {
            while (j >= (left + (dir - 2) / 4) && j <= (right - (dir) / 4) && i >= (up + (dir + 1) / 4) && i <= (down - (dir - 1) / 4)) {
                list.add(matrix[i][j]);
                i += directions[dir % 4][0];
                j += directions[dir % 4][1];
            }
            //roll back when crossing the borders
            i -= directions[dir % 4][0];
            j -= directions[dir % 4][1];
            dir++;
            //move forward when changing direction
            i += directions[dir % 4][0];
            j += directions[dir % 4][1];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4, 6}, {2, 5, 6, 7, 8},};
        new SpiralOrder().spiralOrder(matrix);
    }
}
