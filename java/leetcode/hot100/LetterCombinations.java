package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<Character,char[]>map;
    public LetterCombinations(){
        map=new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
    }
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        if(digits.length()==0)
            return res;

        char digit=digits.charAt(0);
        for (char c:map.get(digit)){
            StringBuilder sb=new StringBuilder();
            sb.append(c);
            backtrace(digits,0,sb,res);
        }

        return res;
    }


    public void backtrace(String digits,int first,StringBuilder sb,List<String>res){
        if(first==digits.length()){
            res.add(sb.toString());
        }
        else {
            char digit = digits.charAt(first + 1);
            for (char c : map.get(digit)) {
                sb.append(c);
                backtrace(digits, first + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
