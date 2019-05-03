package leetcode.linkedlist;

public class 删除排序链表中的重复元素 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, cur = head;
        while(cur != null){
            while(pre.val == cur.val && cur != null){
                ListNode temp = cur;
                cur = cur.next;
                temp.next = null;
            }
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}
