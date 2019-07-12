package nkw.xz2018.jingdong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 括号匹配方案 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int result = 1;
        int count = 0;
        for(int i = 0 ; i < s.length(); i ++){
            if(s.charAt(i) == '(')
                count++;
            else{
                result *= count;
                count--;
            }
        }
        System.out.println(result);
    }
}
