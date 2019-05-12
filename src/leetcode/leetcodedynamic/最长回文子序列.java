package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/11
 */
public class 最长回文子序列 {
    /**
     * dp[i][j] 表示[i ... j]中最长回文子序列的长度
     *
     * 状态转移方程： dp[i][j] = dp[i + 1][j - 1] + 2 if s[i] == s[j]
     *                  dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) if s[i] != s[j]
     *
     * 边界条件： dp[i][j] = 1; i == j
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i --){
            dp[i][i] = 1;
            for(int j = i + 1; j < n ; j ++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
