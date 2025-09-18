package hot100;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][]dp=new int[m][n];
        dp[0][0]=grid[0][0];

        for (int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for (int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    // Overtime
    int minSum=Integer.MAX_VALUE;
    public int minPathSumII(int[][] grid) {
        backtrace(grid,0,0,0);
        return minSum;
    }

    public void backtrace(int[][]grid,int i,int j,int sum){
        if(i>=grid.length || j>=grid[0].length)
            return;

        sum+=grid[i][j];

        if(i==grid.length-1 && j==grid[0].length-1) {
            minSum=Math.min(minSum,sum);
            return;
        }

        backtrace(grid,i+1,j,sum);
        backtrace(grid,i,j+1,sum);
    }

    public static void main(String[] args) {

    }
}
