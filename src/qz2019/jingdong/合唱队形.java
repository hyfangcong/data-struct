package qz2019.jingdong;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/8/24
 */
public class 合唱队形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n ; i++){
            if(stack.isEmpty() || stack.peek()<=arr[i]){
                stack.push(arr[i]);
            }else{
                int top = stack.pop();
                while (!stack.isEmpty()){
                    if(stack.peek() > arr[i]){
                        stack.pop();
                    }else{
                        break;
                    }
                }
                stack.push(top);
            }
        }
        System.out.println(stack.size());
    }
}
