package leetcode.linkedlist;

import java.util.List;

public class 删除排序链表中的重复元素II {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = dummyHead.next;

        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                while(cur != null && cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;

                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
