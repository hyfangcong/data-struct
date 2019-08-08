package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 最长公共子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
        System.out.println(process(s, p));
    }

    public static int process(String s, String p){
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n; j ++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
