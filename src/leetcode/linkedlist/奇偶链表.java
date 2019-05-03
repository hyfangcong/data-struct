package leetcode.linkedlist;

public class 奇偶链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {

        //flag == true 表示是奇数， flag == false 表示是偶数
        boolean flag = true;
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode p = dummyHead1, q = dummyHead2;
        ListNode cur = head;
        while(cur != null){
            if(flag){
                p.next = cur;
                p = cur;
            }else{
                q.next = cur;
                q = cur;
            }
            flag = !flag;
            cur = cur.next;
        }

        if(dummyHead1.next == null)
            return dummyHead2.next;
        if(dummyHead2.next == null)
            return dummyHead1.next;

        q.next = null;
        p.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
