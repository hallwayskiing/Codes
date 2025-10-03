package hot100.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        backtrace(n,0,0,new StringBuilder(),res);
        return res;
    }

    public void backtrace(int n,int left,int right ,StringBuilder sb,List<String>res){
        if(sb.length()==n*2){
            res.add(sb.toString());
            return;
        }

        if(left<n){
            sb.append('(');
            backtrace(n,left+1,right,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(right<left){
            sb.append(')');
            backtrace(n,left,right+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
