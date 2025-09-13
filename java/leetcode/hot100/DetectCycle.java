package hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class DetectCycle {
    //哈希表法
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }

    //双指针法
    public ListNode detectCycleII(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            //当快慢指针相遇时，快指针走了2k步，慢指针走了k步，环外长度a，环长b，快指针多走了n圈，则有：
            //2k=k+nb，k=nb
            //由于a+nb的位置即环入口，慢指针再走a步即可到达环入口
            //所以再额外让一个指针从起点出发，走a步即可与慢指针在环入口处相遇
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
