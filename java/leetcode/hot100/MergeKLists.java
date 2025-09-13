package hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null)
            return null;

        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        for (ListNode head:lists) {
            if(head!=null) {
                pre.next = head;
                while (head.next != null)
                    head = head.next;
                pre = head;
            }
        }
        return mergeSort(dummy.next);
    }

    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null)
            return head;

        ListNode fast=head.next,slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode tmp=slow.next;
        slow.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(tmp);
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while (left!=null && right!=null){
            if(left.val<right.val){
                curr.next=left;
                left=left.next;
            }
            else {
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        curr.next=left!=null?left:right;
        return dummy.next;
    }

    //优先级队列
    public ListNode mergeKListsII(ListNode[]lists){
        if(lists==null)
            return null;

        Queue<ListNode>queue=new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        for (ListNode head:lists){
            while (head!=null){
                ListNode next=head.next;
                head.next=null;
                queue.add(head);
                head=next;
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while (!queue.isEmpty()){
            curr.next=queue.poll();
            curr=curr.next;
        }
        return dummy.next;
    }
}
