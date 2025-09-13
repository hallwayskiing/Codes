package hot100;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode();
        ListNode cur=head;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        if (list1!=null){
            cur.next=list1;
        }
        if (list2!=null){
            cur.next=list2;
        }

        return head.next;
    }
}
