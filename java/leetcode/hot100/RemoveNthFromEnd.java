package hot100;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //当需要删除第一个节点时，需要使用到虚拟节点
        ListNode dummy=new ListNode(0,head);
        ListNode fast=head,slow=dummy;
        //先让快指针先走n步
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        //由于慢指针初始指向虚拟节点，当快指针走到链表末端时，慢指针正好指向待删除节点的前一个节点
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        //跳过待删除节点
        slow.next=slow.next.next;

        return dummy.next;
    }
}
