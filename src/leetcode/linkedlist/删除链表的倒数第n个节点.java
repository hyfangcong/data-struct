package leetcode.linkedlist;

public class 删除链表的倒数第n个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead, q = head;
        while(q != null && n > 0){
            q = q.next;
            n --;
        }

        while(q != null){
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return dummyHead.next;
    }
}
