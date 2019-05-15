package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class K个逆序对数组 {
    /**
     * dp[n][k]表示1到n的数字中，逆序对的个数为k的不同数组的个数
     *
     * 如果n放在最后的位置，那么k个逆序对就在前面n-1的数组中
     * 如果n放在倒数第二个位置，那么就会出现一个逆序对，则前面n-1的数组中有k-1个逆序对
     *..........
     * 如果n放在第一个位置，那么就会出现n-1个逆序对，则前面n-1的数组中有k-n+1个逆序对
     *
     * 递推关系：dp[n][k] = dp[n - 1][k] + dp[n - 1][k - 1] + dp[n - 1][k - 2] + ... + dp[n - 1][k+1-n+1] + dp[n -1][k - n + 1]
     *           dp[n][k + 1] = dp[n - 1][k + 1] + dp[n - 1][k] + ... +dp[n - 1][k + 1 -n + 1]
     *
     *           因此： dp[n][k + 1] = dp[n - 1][k + 1] + dp[n][k] - dp[n - 1][k - n + 1]
     *           由于dp[n][k]可能出现负数，因此dp[n][k] = dp[n][k] + MOD
     */

    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        if(k > n*(n - 1) / 2 || k < 0)
            return 0;
        if(k == 0 || k == n *(n - 1) / 2)
            return 1;

        int mod = 1000000007;
        dp[2][0] = 1;
        dp[2][1] = 1;
        for(int i = 3 ; i <= n ; i ++){
            dp[i][0] = 1;
            for(int j = 1 ; j <= Math.min(k, n * (n - 1) / 2); j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if(j >= i)
                    dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + mod) % mod; //处理dp[i][j]为负数的情况
            }
        }
        return (int)dp[n][k];
    }
}
