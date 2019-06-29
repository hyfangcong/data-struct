package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */

/**
 * 将字符串s拆成两个字串，求两个字串的最长公共子序列
 */
public class 平方串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int res = 0;
        for(int i = 1; i < s.length(); i ++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int j = 1; j <= m;  j++){
                for(int k = 1; k <= n; k ++){
                    if(s1.charAt(j - 1) == s2.charAt(k - 1))
                        dp[j][k] = dp[j - 1][k - 1] + 1;
                    else
                        dp[j][k] = Math.max(dp[j][k - 1], dp[j - 1][k]);
                }
            }
            res = Math.max(res, dp[m][n]);
        }
        System.out.println(res * 2);
    }
}
