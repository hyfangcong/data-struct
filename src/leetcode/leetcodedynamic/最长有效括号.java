package leetcode.leetcodedynamic;

import java.util.Iterator;
import java.util.Stack;

public class 最长有效括号 {
    //暴力解法
    public static int longestValidParentheses(String s) {
        int res = 0;  //res表示字符串s中最长的括号数
        for(int i = 0 ; i < s.length() - 1; i ++){
            int count = 0; //记录 “（”的个数

            //p表示子串中有效括号的个数； q表示可能的有效括号个数，当count==0时，将q的值赋给p
            int p = 0, q = 0;
            for(int j = i ; j < s.length(); j ++){
                if(s.charAt(j) == ')'){
                   count--;
                   q++;
                   if(count == 0){
                       p += q;
                       q = 0;
                   }else if(count < 0){
                       break;
                   }
                }else{
                    count++;
                }
            }
            res = res > p ? res : p;
        }
        return res * 2;
    }

    //利用栈来记录索引，最后遍历栈，找出相邻元素的索引之差的最大值
    public static int longestValidParentheses2(String s) {
        Stack<Node> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            if(s.charAt(i) == '(')
                stack.add(new Node(i, '('));
            else{
                if(stack.isEmpty())
                    stack.add(new Node(i, ')'));
                else{
                    if(stack.peek().c == '(')
                        stack.pop();
                    else
                        stack.add(new Node(i, ')'));
                }
            }
        }

        if(stack.isEmpty())
            return s.length();
        int max = 0;
        int lastIndex = -1; //记录相邻元素的位置
        Iterator<Node> iterator = stack.iterator();
        while(iterator.hasNext()){
            int cur = iterator.next().index;
            max = Math.max(max, cur - lastIndex - 1);
            lastIndex = cur;
        }
        return Math.max(max, s.length() - lastIndex - 1);
    }

    static class Node{
        int index;
        char c;
        public Node(int index, char c){
            this.index = index;
            this.c = c;
        }
    }


    /**
     *1. 从左向右：
     *          （ 的数量 < )的数量时，一定不满足，数量清零，继续向前
     *          （ 的数量 == )的数量时， 当前数量有效，记录并继续
     *          ( 的数量 > ) 的数量时， 无法确定是否有效，继续前进。
     *
     * 2. 从右向左：
     *           （ 的数量 > )的数量时，一定不满足，数量清零，继续向前
     *           （ 的数量 == )的数量时， 当前数量有效，记录并继续
     *           ( 的数量 < ) 的数量时， 无法确定是否有效，继续前进。
     *
     * 因此，结合两种情况，取最大值即可。
     *
     */
    public static int longestValidParentheses3(String s) {
        int left = 0, count = 0, temp = 0;
        for(int i = 0 ; i < s.length(); i ++){
            if(s.charAt(i) == ')'){
                count--;
                temp += 2;
                if(count < 0){
                    temp = 0;
                    count = 0;
                }else if(count == 0){
                    left = left > temp ? left : temp;
                }
            }else{
                count++;
            }
        }

        int right = 0;
        count = 0;
        temp = 0;
        for(int i = s.length() - 1 ; i >= 0; i--){
            if(s.charAt(i) == '('){
                count--;
                temp += 2;
                if(count < 0){
                    temp = 0;
                    count = 0;
                }
                else if(count == 0){
                    right = right > temp ? right : temp;
                }
            }else
                count++;
        }
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses3(s));
    }
}
