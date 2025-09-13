package hot100;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[]last=new int[26];
        for (int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }

        List<Integer>res=new ArrayList<>();
        int begin=0;
        int bound=0;
        for (int i=0;i<s.length();i++) {
            bound = Math.max(bound, last[s.charAt(i) - 'a']);
            if (i == bound) {
                res.add(bound - begin + 1);
                begin = bound + 1;
            }
        }

        return res;
    }
}
