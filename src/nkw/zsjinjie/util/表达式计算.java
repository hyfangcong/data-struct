package nkw.zsjinjie.util;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/8/5
 */
public class 表达式计算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(solution(s));
            System.out.println(getValue(s));
        }
    }


    /**
     * 使用递归进行计算
     * @param str
     * @return
     */
    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;
        int[] bra = null;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else {
                bra = value(str, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[] { getNum(que), i };
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }


    /**
     * 使用两个栈来进行计算
     * @param s
     * @return
     */
    public static int solution(String s){
        Stack<Integer> opnd = new Stack<>();  //操作数栈
        Stack<Character> optr= new Stack<>(); //操作符栈
        optr.push('#');
        int num = 0;

        /**
         * 用于判断是负号还是减号
         *
         * 负号只会出现在表达式的开头，或者'('之后。因此遇到'('就把is_minus = true, 遇到其他符号就把is_minus = false
         */
        boolean is_minus = true;
        /**
         * 循环中的操作不同的判断对i的改变不一样，因此不能够在for中统一规定。
         * 需要在不同的逻辑中按照自己的需要进行改变
         */
        for(int i = 0; i < s.length(); ){
            if(s.charAt(i) == '-' && is_minus){
                opnd.push(0);
                optr.push(s.charAt(i));
                i++;
            }
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                is_minus = false;

                /**
                 * 在数组中，使用index必须要判断数组是否越界
                 */
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                opnd.push(num);
                num = 0;
            }else if(s.charAt(i) == '('){
                is_minus = true;
                optr.push(s.charAt(i));
                i++;
            }else if(s.charAt(i) == ')'){
                is_minus = false;
                while(optr.peek() != '('){
                    char op = optr.pop();
                    int second = opnd.pop();
                    int first =  opnd.pop();
                    opnd.push(calculate(op,first, second));
                }
                optr.pop(); // 弹出'('
                i++;
            }else{ //加减乘除
                while(getLevel(s.charAt(i)) - getLevel(optr.peek()) <= 0){
                    char op = optr.pop();
                    int second = opnd.pop();
                    int first =  opnd.pop();
                    opnd.push(calculate(op,first, second));
                }
                optr.push(s.charAt(i));
                i++;
            }
        }
        while(optr.peek() != '#'){
            char op = optr.pop();
            int second = opnd.pop();
            int first =  opnd.pop();
            opnd.push(calculate(op,first, second));
        }
        return opnd.pop();
    }

    private static int calculate(char op, int first, int second) {
        switch (op){
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
                default:
                    return 0;
        }
    }

    private static int getLevel(Character c){
        switch (c){
            case '*':
            case '/':
                return '2';
            case '+':
            case '-':
                return '1';
            case '(':
                return 0;
            case '#':
                return -1;
                default:
                    return -1;
        }
    }
}
