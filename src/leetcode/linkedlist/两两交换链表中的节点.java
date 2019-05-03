package leetcode.linkedlist;

import java.util.List;

public class 两两交换链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归解法
    public ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    //当前节点的下一个节点以及下下一个节点都不为空的时候，才进行交换。
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null && pre.next.next != null){
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            pre.next = node2;

            pre = node1;
        }

        return dummyHead.next;
    }
}
