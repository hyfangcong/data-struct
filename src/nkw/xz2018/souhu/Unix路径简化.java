package nkw.xz2018.souhu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/7/2
 */
public class Unix路径简化 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.next().split("/");
        int n = strings.length;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < n ; i ++){
            if(strings[i].equals("") || strings[i].equals("."))
                continue;
            if(strings[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(strings[i]);
            }
        }

        if(stack.isEmpty())
            System.out.println("/");
        else{
            String res = "";
            while(!stack.isEmpty()){
                res = stack.pop() + res;
                res = "/" + res;
            }
            System.out.println(res);
        }
    }
}
