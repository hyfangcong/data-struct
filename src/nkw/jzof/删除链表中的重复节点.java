package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 删除链表中的重复节点 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode pre = dummyHead, cur = pHead;
        boolean flag;
        while(cur != null){
            flag = false;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                flag = true;
            }
            if(flag){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}

