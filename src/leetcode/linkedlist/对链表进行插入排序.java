package leetcode.linkedlist;

public class 对链表进行插入排序 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            ListNode p = dummyHead;
            while(p.next != null && head.val > p.next.val)
                p = p.next;

            head.next = p.next;
            p.next = head;
            head = next;
        }
        return dummyHead.next;
    }
}
