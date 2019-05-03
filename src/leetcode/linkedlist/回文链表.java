package leetcode.linkedlist;

public class 回文链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome2(ListNode head){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead, p2 = dummyHead;
        while(p2 != null && p2.next != null){
            p = p.next;
            p2 = p2.next.next;
        }

        //后半部分的链表的头结点为head2
        ListNode head2 = p.next;
        //p.next = null;

        head2 = reverse(head2);
        while(head2 != null){
            if(head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }


    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            len++;
        }

        if(len == 0 || len == 1)
            return true;

        int k = len / 2;
        ListNode q = head;
        while(k > 1){
            q = q.next;
            k --;
        }

        //后半部分链表的头结点head2
        ListNode head2;

        //这里不需要判断，只需将后半部分的链表与前半部分的链表进行check即可。
        if(len % 2 == 1)
            head2 = q.next.next;
        else
            head2 = q.next;

        q.next = null;
        head2 = reverse(head2);

        while(head != null){
            if(head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
