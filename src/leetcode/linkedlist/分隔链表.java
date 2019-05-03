package leetcode.linkedlist;

import java.util.List;

public class 分隔链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition2(ListNode head, int x){
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode p = dummyHead1, q = dummyHead2;

        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                p.next = cur;
                p = cur;
            }else{
                q.next = cur;
                q = cur;
            }
            cur = cur.next;
        }

        if(dummyHead1.next == null)
            return dummyHead2.next;

        if(dummyHead2.next == null)
            return dummyHead1.next;

        q.next = null;
        p.next = dummyHead2.next;
        return dummyHead1.next;

    }

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null, head2 = null;
        ListNode p = null, q = null;

        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                if(p == null){
                    head1 = cur;
                    p = cur;
                }else{
                    p.next = cur;
                    p = cur;
                }
            }else{
                if(q == null){
                    head2 = cur;
                    q = cur;
                }
                else{
                    q.next = cur;
                    q = cur;
                }
            }
            cur = cur.next;
        }

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        q.next = null;
        p.next = head2;
        return head1;
    }
}
