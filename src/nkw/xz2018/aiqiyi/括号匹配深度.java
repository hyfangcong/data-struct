package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */
public class 括号匹配深度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '(')
                count++;
            else{
                max = Math.max(max, count);
                count--;
            }
        }
        System.out.println(max);
    }
}
