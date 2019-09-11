import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: fangcong
 * @date: 2019/8/27
 */

public class Main {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        values.add("()[]{}");
        List<String> ans = braces(values);
        System.out.println();
    }

    static List<String> braces(List<String> values){
        List<String> ans = new ArrayList<>();
        for(String s : values){
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for(int i = 0 ; i < s.length(); i ++){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                }else{
                    char c = s.charAt(i);
                    if(c == '(' || c == '[' || c == '{'){
                        stack.push(c);
                    }else if(!stack.isEmpty() && (c == ')' && stack.peek() == '(') ||
                            (c == ']' && stack.peek() == '[') ||
                            (c == '}' && stack.peek() == '{')){
                        stack.pop();
                    }else{
                        flag = true;
                        ans.add("NO");
                        break;
                    }
                }
            }
            if(!flag && stack.isEmpty())
                ans.add("YES");
        }
        return ans;
    }
}