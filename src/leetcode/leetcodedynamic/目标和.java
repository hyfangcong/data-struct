package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/10
 */
public class 目标和 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        目标和 tt = new 目标和();
        System.out.println(tt.findTargetSumWays(nums, 3));
    }
    public int findTargetSumWays(int[] nums, int S) {
        find(nums,0, S, 0);
        return count;
    }

    /**
     * 暴力递归
     */
    int count = 0;
     private void find(int[] nums , int sum , int s, int index){
         if(index == nums.length){
             count += sum == s ? 1 : 0;
             return;
         }

         find(nums, sum + nums[index], s , index + 1);
         find(nums, sum - nums[index], s, index + 1);
     }

    /**
     * 原问题等同于找到一个正子集和一个负子集的和等于target
     *
     * 即为找到一个子集的和等于(target + sum(nums)) / 2
     *
     * 和分割等和子集一样的解法。属于 0 - 1背包问题
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < S || (S + sum) % 2 == 1)
            return 0;

        return find(nums, (S + sum) / 2);
    }

    private int find(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = target; j >= num ;  j --){
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
