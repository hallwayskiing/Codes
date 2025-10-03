package hot100.LinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
