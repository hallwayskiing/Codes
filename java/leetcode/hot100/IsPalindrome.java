package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        for (int i = 0,j=list.size()-1; i < j; i++,j--) {
            if (!list.get(i).equals(list.get(j))){
                return false;
            }
        }

        return true;
    }
}
