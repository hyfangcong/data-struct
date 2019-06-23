package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        int res = 0;
        for(int i = 1 ; i < pairs.length ; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
