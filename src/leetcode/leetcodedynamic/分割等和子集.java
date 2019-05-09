package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/8
 */
public class 分割等和子集 {
    /**
     * 0 - 1 背包问题
     *
     * 在nums中能否取出容量为capacity的一个背包。 capacity = sum(nums) / 2;
     *
     * dp[i]表示能否填满容量为i的背包
     *
     * 状态转移方程： dp[i] = dp[i] || dp[i - nums[i]], i 为背包的容量。 等式后面的dp[i] 为上一行容量为i的状态。
     *  dp[i] = dp[i],是指这次不去nums[i]，  dp[i] = dp[i - nums[i]], 是指这次取出nums[i]
     */

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
      int n = nums.length;
      if(n < 2)
          return false;

      int sum = 0;
      for(int num : nums)
          sum += num;
      if(sum % 2 != 0)
          return false;
      int capacity = sum / 2;
      boolean[] dp = new boolean[capacity + 1];
      //初始化第一行
        for(int i = 1 ; i <= capacity ; i ++)
            dp[i] = nums[0] == i;

        for(int i = 1 ; i < n; i ++){
            for(int j = capacity ; j >= 1 ; j --){
                dp[j] = dp[j] || (j - nums[i] >= 1 && dp[j - nums[i]]);
            }
        }
        return dp[capacity];
    }
}
