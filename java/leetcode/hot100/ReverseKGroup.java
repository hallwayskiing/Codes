package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;

        ListNode dummy=new ListNode(0,head);
        ListNode curr=head;
        List<ListNode>list=new ArrayList<>();

        int count=k;
        while(curr!=null){
            if(count==k) {
                list.add(curr);
                count=0;
            }
            curr=curr.next;
            count++;
        }

        ListNode pre=dummy;
        for (int i = 0; i < list.size()-1; i++) {
            pre.next=reverse(list.get(i),k);
            pre=list.get(i);
        }
        //对于最后一个节点进行特殊处理
        ListNode last=list.get(list.size()-1);
        ListNode lastCurr=last;
        int len=0;
        while (lastCurr!=null){
            lastCurr=lastCurr.next;
            len++;
        }
        if(len==k){
            pre.next=reverse(last,k);
        }
        else {
            pre.next=last;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head, int k){
        if(k==1){
            return head;
        }

        ListNode node=reverse(head.next,k-1);
        head.next.next=head;
        head.next=null;
        return node;
    }

    public ListNode reverseKGroupII(ListNode head,int k){
        if(head==null || head.next==null)
            return head;

        ListNode tail=head;
        for (int i = 0; i < k; i++) {
            if(tail==null)
                return head;
            tail=tail.next;
        }

        ListNode newHead=reverse(head,tail);
        head.next=reverseKGroupII(tail,k);

        return newHead;
    }

    //左闭右开区间
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
