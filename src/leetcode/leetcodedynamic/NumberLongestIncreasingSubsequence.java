package leetcode.leetcodedynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/15
 */
public class NumberLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] len = new int[nums.length]; //记录以nums[i]结尾的最长上升子序列的个数
        int[] dp = new int[nums.length]; // 以nums[i]结尾的最长上升子序列的长度
        int max = 1;   //[0...i]中所有上升子序列中最长上升子序列的长度
        for (int i = 0; i < nums.length; i++) {
            dp[i] = len[i] = 1;
            for(int j = 0 ; j < i ; j ++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        len[i] = len[j];
                        dp[i] = dp[j] + 1;
                    }
                    else if(dp[j] + 1 == dp[i])  //长度都是dp[i]的上升子序列，但是其中的元素不同
                        len[i] += len[j];
                }
            }
            max = max > dp[i] ? max : dp[i];
        }

        int sum = 0 ;
        for(int i = 0 ; i < nums.length; i ++){
            if(dp[i] == max)
                sum += len[i];
        }
        return sum;
    }
}