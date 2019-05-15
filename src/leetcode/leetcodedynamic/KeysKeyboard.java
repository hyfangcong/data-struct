package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class KeysKeyboard {
    /**
     * copy和paste可以任意选择，那么'A'的长度可以为1，2，3 ... n
     *
     */
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }

            }
        }
        return dp[n];
    }
}
