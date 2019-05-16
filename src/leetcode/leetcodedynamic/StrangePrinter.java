package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/15
 */
public class StrangePrinter {

    public static void main(String[] args) {
        System.out.println(strangePrinter("aaabbb"));
    }

    /**
     * dp[i][j]表示[i...j]所需的最少步数
     *
     * 暴力解法：
     *         从len = 1 到 len = n-1， 依此计算dp[i...i + len],最后dp[0][n - 1]就是所求结果
     *        递推关系： dp[i][j] = min(dp[i][k - 1] + dp[k, j] + if s[k - 1] == s[j] ? 1 : 0 , dp[i][j])
     *        边界条件： dp[i][j] = 1, i == j
     *
     *        ps:为了保证能够满足题意，dp[i][j] 至多为 j - i + 1 = len + 1
     *
     */
    public static int strangePrinter(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i ++)
            dp[i][i] = 1;
        for(int len = 1; len < n ; len ++){
            for(int i = 0 ; i + len < n ;i ++){
                int j = i + len;
                dp[i][j] = len + 1;
                for(int k = i + 1 ; k <= j ; k ++){
                    int tmp = dp[i][k - 1] + dp[k][j] +  (s.charAt(k - 1) == s.charAt(j) ? -1 : 0);
                    dp[i][j] = Math.min(dp[i][j], tmp);
                }
            }
        }
        return dp[0][n - 1];
    }
}
