package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 链表中环的入口节点 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode p = pHead, q = pHead;
        while(p != null){
            if(p.next == null)
                return null;
            p = p.next.next;
            q = q.next;
            if(p == q)
                break;;
        }
        if(p != q)
            return null;

        p = pHead;
        while (p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }


}

