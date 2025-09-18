package hot100;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 *
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int maxLength = 0;
        int[] dp = new int[s.length()];
        // dp[i] 表示以位置 i 结尾的最长有效括号长度

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // 只有当前字符是 ')' 时才可能形成有效括号
            if (currentChar == ')') {
                char prevChar = s.charAt(i - 1);

                // 情况1: ...()  形如 "()" 的直接匹配
                if (prevChar == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                }
                // 情况2: ...))  需要检查是否能与前面的 '(' 匹配
                else if (prevChar == ')' && dp[i - 1] > 0) {
                    // 找到与当前 ')' 可能匹配的位置
                    int matchingPos = i - dp[i - 1] - 1;

                    // 检查该位置是否存在且为 '('
                    if (matchingPos >= 0 && s.charAt(matchingPos) == '(') {
                        // 当前匹配长度 = 中间的有效长度 + 2(一对括号) + 前面的有效长度
                        dp[i] = dp[i - 1] + 2 + (matchingPos >= 1 ? dp[matchingPos - 1] : 0);
                    }
                }

                // 更新最大长度
                maxLength = Math.max(maxLength, dp[i]);
            }
            // 如果当前字符是 '('，dp[i] 保持0
        }

        return maxLength;
    }
}
