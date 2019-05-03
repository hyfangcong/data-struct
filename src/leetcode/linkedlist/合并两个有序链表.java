package leetcode.linkedlist;

public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)
            p.next = l1;

        if(l2 != null)
            p.next = l2;

        return dummyHead.next;
    }
}
