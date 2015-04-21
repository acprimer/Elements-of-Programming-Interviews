package chap07;

import util.DoublyListNode;
import util.ListNode;

/**
 * Created by yao on 2015/4/21.
 */
public class Problem07_01 {
    // merge singly linked list
    public ListNode merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while(p != null && q != null) {
            if(p.val < q.val) {
                pointer.next = p;
                p = p.next;
            } else {
                pointer.next = q;
                q = q.next;
            }
            pointer = pointer.next;
        }
        pointer.next = p != null ? p : q;
        return head.next;
    }

    // merge doubly linked list
    public DoublyListNode merge(DoublyListNode p, DoublyListNode q) {
        DoublyListNode head = new DoublyListNode(0);
        DoublyListNode pointer = head;
        while(p != null && q != null) {
            if(p.val < q.val) {
                pointer.next = p;
                p.pre = pointer;
                p = p.next;
            } else {
                pointer.next = q;
                q.pre = pointer;
                q = q.next;
            }
            pointer = pointer.next;
        }
        if(p != null) {
            pointer.next = p;
            q.pre = pointer;
        }
        if(q != null) {
            pointer.next = q;
            q.pre = pointer;
        }
        return head.next;
    }
}
