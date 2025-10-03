package hot100.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;

        Deque<Character>stack=new ArrayDeque<>();
        for (char c:s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                char last=stack.pop();
                if((c==')' && last!='(') || (c==']' && last!='[') || (c=='}' && last!='{')) return false;
            }
        }

        return stack.isEmpty();
    }
}
