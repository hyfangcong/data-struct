package qz2019.tengxun;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/20
 */
public class 电话号码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t > 0){
            t--;
            int n = scanner.nextInt();
            String s = scanner.next();
            f(n, s);
        }
    }

    private static void f(int n, String s){
        if(n < 11){
            System.out.println("NO");
            return;
        }
        int i = 0;
        for(; i < s.length(); i ++){
            if(s.charAt(i) == '8')
                break;
        }
        if(n-i < 11)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
