package hot100.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
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
