package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class MaximumLengthRepeatedSubarray {

    /**
     * dp[i][j]表示以A[i-1],B[j-1]结尾的连续子数组的长度
     *
     * max记录，连续子数组相等的最长长度。
     *
     * 如果是连续子序列的相等的最长长度，dp[i][j]表示以A[i-1],B[j-1]结尾的子序列的长度
     *
     * dp[i][j] = dp[i - 1][j - 1] + 1 A[i - 1] == B[j-1]
     *
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) A[i - 1] != B[j - 1]
     *
     * 最后返回： dp[m][n]
     */
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for(int i = 1 ; i<= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
