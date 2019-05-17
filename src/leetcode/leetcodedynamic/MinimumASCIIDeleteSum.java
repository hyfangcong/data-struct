package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class MinimumASCIIDeleteSum {
    /**
     * 典型动态规划： dp【i】【j】表示s1【0， i-1】 和 s2【0， j-1】相等的最小代价。
     *
     * 状态转移方程： dp【i】【j】 = dp【i-1】【j-1】 if s1.charAt(i) == s2.charAr(j)
     *                dp[i][j] = min(dp[i-1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1)) if s1.charAt(i - 1) != s2.charAt(j - 1)
     *
     * 边界条件： dp[0][0] = 0
     *             dp[0][j] = sum(s2.charAt(j - 1))
     *             dp[i][0] = sum(s1.charAt(i - 1))
     */
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 1 ; i <= n ; i ++)
                dp[0][i] = dp[0][i - 1] + s2.charAt(i);

            for(int i = 1; i <= m ; i ++){
                dp[i][0] = dp[i - 1][0] + s1.charAt(i);
            }

            for(int i = 1 ; i <= m ; i ++){
                for(int j = 1; j <= m ; j++){
                    if(s1.charAt(i) == s2.charAt(j))
                        dp[i][j] = dp[i -1][j - 1];
                    else
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i), dp[i][j - 1] + s2.charAt(j));
                }
            }
            return dp[m][n];
        }
}
