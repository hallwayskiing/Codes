package hot100.Substring;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        String res = "";
        if (m < n)
            return res;

        char[] arrS = s.toCharArray(), arrT = t.toCharArray();
        int[] cntS = new int[128], cntT = new int[128];

        for (char c : arrT) {
            cntT[c]++;
        }

        int left = 0;
        int minLeft = -1, minRight = m;
        for (int right = 0; right < m; right++) {
            cntS[arrS[right]]++;
            while (isCovered(cntS, cntT)) {
                if (right - left < minRight - minLeft) {
                    minLeft=left;
                    minRight=right;
                }
                cntS[arrS[left]]--;
                left++;
            }
        }

        return minLeft < 0 ? "" : s.substring(minLeft, minRight + 1);
    }

    public boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 0; i < 128; i++) {
            if (cntS[i] < cntT[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
    }
}
