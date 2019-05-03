package leetcode.linkedlist;

import java.util.List;

public class 翻转链表II {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //ppre指向开始翻转时的前一个节点，ccur指向开始翻转的节点
        ListNode ppre, ccur;

        //pre指向当前翻转节点的前一个节点，cur指向当前需要翻转的节点
        ListNode pre = null, cur = head;
        while(m > 1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ppre = pre;
        ccur = cur;

        while(n > 0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        ccur.next = cur;
        if(ppre != null){
            ppre.next = pre;
            return head;
        }else
            return pre;
    }
}
