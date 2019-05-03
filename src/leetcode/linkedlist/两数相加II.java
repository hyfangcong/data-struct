package leetcode.linkedlist;

import java.util.Stack;

public class 两数相加II {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(-1);
        int carry = 0;
        while(!stack1.empty() || !stack2.empty() || carry != 0){
            if(!stack1.empty())
                carry += stack1.pop();
            if(!stack2.empty())
                carry += stack2.pop();

            ListNode node = new ListNode(carry % 10);
            node.next = dummyHead.next;
            dummyHead.next = node;
            carry /= 10;
        }
        return dummyHead.next;
    }
}
