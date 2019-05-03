package leetcode.linkedlist;

public class 旋转链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }

        k = k % len;
        if(k == 0)
            return head;

        k = len - k;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode q = dummyHead;

        while (k > 0){
            q = q.next;
            k--;
        }

        //head2为倒数第K可节点
        ListNode head2 = q.next;
        ListNode r = head2;
        q.next = null;

        while(r.next != null)
            r = r.next;
        r.next = dummyHead.next;
        //释放dummyHead结点
        dummyHead.next = null;
        return head2;
    }
}
