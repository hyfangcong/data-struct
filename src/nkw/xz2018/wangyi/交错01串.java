package nkw.xz2018.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/25
 */
public class 交错01串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int max = Integer.MIN_VALUE;
        int sum = 1;
        for(int i = 0; i < s.length() - 1; i ++){
            if(s.charAt(i) == s.charAt(i + 1)){
                max = Math.max(max, sum);
                sum = 1;
            }else{
                sum++;
            }
        }
        max = Math.max(max, sum);
        System.out.println(max);
    }
}
