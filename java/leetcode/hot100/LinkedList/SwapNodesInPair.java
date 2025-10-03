package hot100.LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while (head!=null && head.next!=null){
            ListNode next=head.next;
            ListNode newHead=next.next;
            curr.next=next;
            next.next=head;
            head.next=null;

            curr=head;
            head=newHead;
        }

        if(head!=null)curr.next=head;

        return dummy.next;
    }
}
