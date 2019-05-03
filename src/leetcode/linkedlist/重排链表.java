package leetcode.linkedlist;

public class 重排链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead, p2 = dummyHead;
        while(p2 != null && p2.next != null){
            p = p.next;
            p2 = p2.next.next;
        }

        //后半部分链表的头结点head2
        //对后半部分链表进行翻转
        ListNode head2 = p.next;
        p.next = null;
        head2 = reverse(head2);

        ListNode q = dummyHead.next;
        while(head2 != null){
            ListNode next = head2.next;
            head2.next = q.next;
            q.next = head2;
            q = head2.next;
            head2 = next;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null , cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
