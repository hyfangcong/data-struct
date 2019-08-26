package qz2019.shangtang;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/8/19
 */
public class 逆波兰式 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < arr.length;  i++){
            if(arr[i].equals("*") || arr[i].equals("-") || arr[i].equals("/") || arr[i].equals("+")){
                int second = stack.pop();
                int first = stack.pop();
                int tmp = calculate(arr[i], first, second);
                stack.push(tmp);
            }else{
                stack.push(Integer.valueOf(arr[i]));
            }
        }
        System.out.println(stack.pop());
    }

    public static int calculate(String opt, int a, int b){
        if(opt.equals("*")){
            return a*b;
        }else if(opt.equals("/")){
            return a / b;
        }else if(opt.equals("+")){
            return a+b;
        }else
            return a - b;
    }
}
