package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 打家劫舍 {
    /**
     * dp[i]表示 [0...i - 1]能够偷取的最大金额
     *
     * dp[i] = max(dp[i - 1] , dp[i - 2] + nums[i])
     *
     *
     * dp[0] = 0 ; dp[1] = nums[0];
     *
     */

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0; dp[1] = nums[0];
        for(int i = 2; i <= n ; i ++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
