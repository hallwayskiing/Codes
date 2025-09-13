package hot100;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]dp=new boolean[s.length()+1];
        Set<String>set=new HashSet<>(wordDict);
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        new WordBreak().wordBreak("aaaaaaa",new ArrayList<>(Arrays.asList("aaaa","aaa")));
    }
}
