package hot100;

import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {
    public ListNode sortListBubble(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        ListNode lastSorted=null;
        ListNode dummy=new ListNode(0,head);

        do {
            swapped = false;
            ListNode pre=dummy;
            ListNode current = dummy.next;

            while (current.next != lastSorted) {
                if (current.val > current.next.val) {
                    //交换
                    ListNode nextNode=current.next;
                    pre.next=nextNode;
                    current.next=nextNode.next;
                    nextNode.next=current;
                    pre=nextNode;
                    swapped=true;
                }
                //不交换时也要前进
                else {
                    pre=current;
                    current=current.next;
                }
            }
            lastSorted = current;
        } while (swapped);

        return dummy.next;
    }

    public ListNode sortListMerge(ListNode head){
        if(head==null || head.next==null)
            return head;

        ListNode fast=head.next,slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode tmp=slow.next;
        slow.next=null;
        ListNode left=sortListMerge(head);
        ListNode right=sortListMerge(tmp);
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

    public void bubbleSort(int[]list){
        int n=list.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(list[j]>list[j+1]) {
                    int temp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
    }

}
