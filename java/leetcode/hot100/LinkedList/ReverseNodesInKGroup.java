package hot100.LinkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;

        while (true) {
            // Find the tail of current group
            int count = 0;
            while (count < k && tail != null) {
                tail = tail.next;
                count++;
            }
            if (tail == null) break; // 不足 k 个

            //True start because pre is a dummy
            ListNode start = pre.next;
            ListNode next = tail.next;
            tail.next = null;              // Cut off temporarily
            pre.next = reverse(start);    // reverse from start to tail
            start.next = next;            // link back

            pre = tail = start;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
