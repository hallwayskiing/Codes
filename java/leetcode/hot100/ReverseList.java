package hot100;

import java.util.List;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }

    public ListNode reverseListII(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode pre=null,next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode node=new ReverseList().reverseList(head);
        System.out.println(node);
    }
}
