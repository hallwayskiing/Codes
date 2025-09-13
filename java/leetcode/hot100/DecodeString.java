package hot100;

import java.util.*;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<Character>deque=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        int left=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                deque.addLast(c);
            }
            else if(Character.isLetter(c)){
                if(left>0)
                    deque.addLast(c);
                else
                    sb.append(c);
            }
            else if(c=='['){
                deque.addLast(c);
                left++;
            }
            else if(c==']'){
                List<Character>temp=new ArrayList<>();
                while (!deque.isEmpty()){
                    char ch=deque.pollLast();
                    if(ch=='['){
                        left--;
                        break;
                    }
                    temp.add(ch);
                }

                int num=0,mul=1;
                while (!deque.isEmpty() && Character.isDigit(deque.peekLast())){
                    num+=(deque.pollLast()-'0')*mul;
                    mul*=10;
                }

                for (int j = 0; j < num; j++) {
                    for (int k = temp.size()-1; k >=0 ; k--) {
                        if(left>0)
                            deque.addLast(temp.get(k));
                        else
                            sb.append(temp.get(k));
                    }
                }
            }
        }

        while (!deque.isEmpty())
            sb.append(deque.pollFirst());
        return sb.toString();
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("100[abc]");
    }
}
