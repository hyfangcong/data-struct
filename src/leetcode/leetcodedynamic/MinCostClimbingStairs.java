package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0)
            return 0;
        if(cost.length == 1)
            return cost[0];
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2 ; i < dp.length ; i++){
            if(i == dp.length - 1)
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            else
             dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[dp.length - 1];
    }
}
