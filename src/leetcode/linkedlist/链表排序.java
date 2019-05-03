package leetcode.linkedlist;

import java.util.List;

public class 链表排序 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //自顶向下使用归并排序
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode pre = null, p = head, q = head;
        while(q != null && q.next != null){
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(p);
        return merge(l, r);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode r = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                r.next = l1;
                r = r.next;
                l1 = l1.next;
            }else{
                r.next = l2;
                r = r.next;
                l2 = l2.next;
            }
        }

        if(l1 != null)
            r.next = l1;
        if(l2 != null)
            r.next = l2;

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }
}
