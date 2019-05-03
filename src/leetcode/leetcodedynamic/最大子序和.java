package leetcode.leetcodedynamic;

public class 最大子序和 {


    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            sum += nums[i];
            max = max > sum ? max : sum;

            if(sum < 0)
                sum = 0;
        }
        return max;
    }

    /**
     *分治法
     *
     * dp[i]代表包含i位置的子数组的最大和。
     * dp[i] = max(nums[i], dp[i - 1] + nums[i])
     *
     * res代表到当前位置中所有子数组和的最大值。
     */
    public static int maxSubArray2(int[] nums) {
      int dp = 0;
      int res = Integer.MIN_VALUE;
      for(int i = 0 ; i < nums.length; i++){
          dp = Math.max(nums[i], dp + nums[i]);
          res = res > dp ? res : dp;
      }
      return res;
    }
}
