package hot100;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        int x=0,y=0;
        int ten=0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                x= l1.val;
                l1=l1.next;
            }
            else {
                x=0;
            }

            if(l2!=null){
                y= l2.val;
                l2=l2.next;
            }
            else {
                y=0;
            }

            int sum=x+y+ten;
            if(sum>=10){
                sum-=10;
                ten=1;
            }
            else {
                ten=0;
            }
            curr.next=new ListNode(sum);
            curr=curr.next;
        }
        if(ten==1){
            curr.next=new ListNode(1);
        }
        return dummy.next;
    }
}
