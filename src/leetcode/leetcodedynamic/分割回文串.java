package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 分割回文串 {
    /**
     * 用dp先求出s[i,j]是否是回文串, 递推关系式s[i] == s[j], a[i][j] == a[i + 1][j - 1]; s[i] != s[j], a[i][j] = false;
     *
     * 然后再用动态规划求出dp[i](s[0...i]最少需要多少次分割为回文串)，递归关系式为：
     * a[j][i] == false , dp[i] = i; a[j][i] = true, dp[i] = min(dp[j - 1] + 1, dp[i]);
     */

    public int minCut(String s) {
        int n = s.length();
        if(n == 0)
            return 0;

        boolean[][] a = new boolean[n][n];
        int[] dp = new int[n];

        for(int i = 0 ; i < n ; i ++){
            dp[i] = i;
            for(int j = 0 ; j <= i; j ++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || a[j + 1][i - 1])){
                    a[j][i] = true;

                    /**
                     * 这里为dp[j - 1] + 1 而不是dp[j] + 1
                     */
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
