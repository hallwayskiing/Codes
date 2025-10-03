package hot100.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode pA = headA, pB = headB;
        while (pA != null) {
            set.add(pA);
            pA = pA.next;
        }

        while (pB != null) {
            if (set.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
