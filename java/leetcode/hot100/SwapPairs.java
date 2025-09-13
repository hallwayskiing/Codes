package hot100;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode dummy=new ListNode(0,head);
        ListNode fast=head,slow=dummy;
        while (true){
            ListNode next=fast.next.next;
            fast.next.next=fast;
            slow.next=fast.next;
            fast.next=next;

            if(fast.next==null || fast.next.next==null){
                break;
            }
            slow=fast;
            fast=fast.next;
        }
        return dummy.next;

    }
}
