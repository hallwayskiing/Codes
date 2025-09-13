package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    public Node copyRandomList(Node head){
        Node newHead=new Node(0);
        Node curr=newHead;
        Node ptr=head;
        List<Node>list=new ArrayList<>();
        Map<Node,Integer> map=new HashMap<>();
        int count=0;
        while (ptr!=null){
            Node newNode=new Node(ptr.val);
            map.put(ptr,count);
            list.add(newNode);
            curr.next=newNode;
            curr=curr.next;
            ptr=ptr.next;
            count++;
        }
        curr=newHead.next;
        ptr=head;
        while (ptr!=null){
            curr.random=ptr.random==null?null:list.get(map.get(ptr.random));
            curr=curr.next;
            ptr=ptr.next;
        }
        return newHead.next;
    }

    public Node copyRandomListII(Node head){
        Map<Node,Node>map=new HashMap<>();
        Node ptr=head;
        while (ptr!=null){
            map.put(ptr,new Node(ptr.val));
            ptr=ptr.next;
        }
        ptr=head;
        while (ptr!=null){
            map.get(ptr).next=map.get(ptr.next);
            map.get(ptr).random=map.get(ptr.random);
            ptr=ptr.next;
        }
        return map.get(head);
    }
}
