package hot100.Dynamic;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++){
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }

        return dp[n];
    }
}
