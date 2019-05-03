package leetcode.linkedlist;

public class 环形链表II {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode detectCycle(ListNode head) {
        boolean iscycle = false;
        ListNode p = head, p2 = head;
        while(p2 != null && p2.next != null){
            p = p.next;
            p2 = p2.next.next;
            if(p == p2){
                iscycle = true;
                break;
            }
        }

        if(iscycle){
            while(head != p){
                p = p.next;
                head = head.next;
            }
            return p;
        }
        return null;
    }
}
