package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/7
 */
public class 组合总数IV {
    /**
     * 递归 + 记忆化搜索
     */
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, - 1);
        memo[0] = 1;
        Arrays.sort(nums);
        return combinat(nums, target);
    }

    private int combinat(int[] nums, int target){
        if(target < 0)
            return 0;

        if(memo[target] != 0)
            return memo[target];

        int sum = 0;
        for(int num : nums){
            sum += combinat(nums, target - num);
        }
        memo[target] = sum;
        return memo[target];
    }

    /**
     * 动态规划： memo[i] = memo[i - nums[0]] + memo[i - nums[1]] + ...
     *
     */
    public int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0 ; i < target ; i++){
            for(int num : nums){
                if(i + num <= target)
                    dp[i + num] += dp[i];
            }
        }
        return dp[target];
    }
}
