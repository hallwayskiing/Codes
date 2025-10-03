package hot100.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * <p>
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * <p>
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 */
public class SubstringWithConcatOfAll {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return res;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int n = s.length();

        if (n < totalLen) return res;

        //set up freq dict
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);

        // iterate wordlen because extra iteration is duplicate
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= n) {
                // retrieve a word from right
                String w = s.substring(right, right + wordLen);
                right += wordLen;

                //If w is in freq dict, add it into the window
                if (wordFreq.containsKey(w)) {
                    window.put(w, window.getOrDefault(w, 0) + 1);
                    count++;

                    // if times exceed, remove from left
                    while (window.get(w) > wordFreq.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) res.add(left);
                } else {
                    // w is not in dict, clear the window and set left to right
                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}
