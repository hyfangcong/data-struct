package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */

/**
 * 分析可知：由于只能从后面添加，只需要判断s.substring(i,n)是否是回文
 *
 *
 */
public class 回文 {
    public static void main(String[] args) {
        solution(args);
    }
    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int n = arr.length;
        for (int i=0; i!=n; i++) {
            if (judgePlalindrome(arr, i, n-1)) {
                System.out.println(n+i);
                return;
            }
        }
        return;
    }

    private static boolean judgePlalindrome(char[]a, int i, int j) {
        while (i <= j) {
            if (a[i++] != a[j--]) { return false; }
        }
        return true;
    }
}
