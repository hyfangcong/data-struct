package leetcode.linkedlist;

public class K个一组反转链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    private boolean isEnough(ListNode node, int k){
        while (node != null && k > 0){
            node = node.next;
            k--;
        }
        return k == 0;
    }

    private ListNode findKNode(ListNode node, int k ){
        while (k > 0){
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverse(ListNode node, int k ){
        ListNode  pre = node, cur = node.next;
        while(k > 1 && cur != null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        return pre;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(!isEnough(head, k))
            return head;
        ListNode kNode = findKNode(head, k);
        ListNode node = reverse(head, k);
        head.next = reverseKGroup(kNode, k);
        return node;
    }

    public ListNode reverseKGroup2(ListNode head, int k){
        ListNode p = head;

        //剩余链表长度是否大于等于k，小于k直接返回
        for(int i = 0 ; i < k;  i++){
            if(p == null)
                return head;

            p = p.next;
        }

        //链表长度为k的反转
        ListNode pre = head, cur = head.next;
        for (int i = 0 ; i < k - 1; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }
}
