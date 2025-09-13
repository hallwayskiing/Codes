package hot100;
class ListNode {
      int val;
      ListNode next;
      ListNode(){}
      ListNode(int x) {
          val = x;
          next = null;
      }
      ListNode(int x,ListNode next){
          val=x;
          this.next=next;
      }
}
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        ListNode pA=headA,pB=headB;
        while (pA!=pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
