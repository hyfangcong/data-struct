package nkw.xz2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 数字游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            max = Math.max(max, helper(scanner.nextInt()));
        }
        System.out.println(max);
    }

    public static int helper(int x){
        String s = x + "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = String.valueOf(chars);
        return Integer.valueOf(s);
    }
}
