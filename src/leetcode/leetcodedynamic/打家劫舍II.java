package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 打家劫舍II {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 0;
        for(int i = 2; i <= n ; i ++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        max = dp[n];

        int[] dp2 = new int[n + 1];
        dp2[0] = 0 ; dp2[1] = nums[0];
        for(int i = 2; i < n; i ++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        return max > dp2[n - 1] ? max : dp2[n - 1];
    }
}
