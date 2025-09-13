package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        backtrace(n,0,0,new StringBuilder(),res);
        return res;
    }

    public void backtrace(int n,int open,int close,StringBuilder sb,List<String>res){
        if(sb.length()==n*2){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            backtrace(n,open+1,close,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(')');
            backtrace(n,open,close+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
