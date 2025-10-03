package hot100.Backtrace;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrace(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrace(String s, int curr, List<String> path, List<List<String>> res) {
        if (curr == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = curr; i < s.length(); i++) {
            if (isPalindrome(s, curr, i)) {
                path.add(s.substring(curr, i + 1));
                backtrace(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
