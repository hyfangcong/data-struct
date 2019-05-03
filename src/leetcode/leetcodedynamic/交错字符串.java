package leetcode.leetcodedynamic;

public class 交错字符串 {

    /**
     * 动态规划:dp[i][j]表示s1（0-i）和s2（0-j）交错组合能否匹配s3（0- i+j-1）
     *
     * 状态转移方程：dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
     *                             (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();
        if(m + n != p)
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i ++){
            for(int j = 0; j <= n; j ++){
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(i == 0){
                    dp[i][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                }else if(j == 0){
                    dp[i][j] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
                }else
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}
