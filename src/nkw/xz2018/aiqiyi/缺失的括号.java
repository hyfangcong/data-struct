package nkw.xz2018.aiqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */
public class 缺失的括号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i < chars.length; i ++){
            if(chars[i] == '(')
                stack.push(chars[i]);
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    sum++;
                }
            }
        }
        System.out.println(sum + stack.size());
    }
}
