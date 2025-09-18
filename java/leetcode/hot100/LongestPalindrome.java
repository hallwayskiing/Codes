package hot100;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        int maxLen=1;
        int start=0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        char[]array=s.toCharArray();

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (array[i] == array[j]) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] |= dp[i + 1][j - 1];
                    }

                    if (dp[i][j]) {
                        maxLen=L;
                        start=i;
                    }
                }
            }
        }

        return s.substring(start,start+maxLen-1);
    }
}
