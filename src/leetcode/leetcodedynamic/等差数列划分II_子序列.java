package leetcode.leetcodedynamic;

import java.util.HashMap;

/**
 * @author: fangcong
 * @date: 2019/5/8
 */
public class 等差数列划分II_子序列 {
    /**
     * dp[i](dest)表示以nums[i]为结尾的以dest为差的等差子序列（长度 > 1）的个数
     *
     * dp[i](dest) = dp[j](dest) + 1 (j for 0 to i - 1)
     *
     * 那么以nums[i]结尾的等差子序列（长度 > 2）的个数为：res[i] = sum(dp[j](nums[i] - nums[j])) for j 0 to i - 1
     */
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3)
            return 0;

        long[] longNum = new long[n];
        for(int i = 0 ; i < n ; i ++)
            longNum[i] = A[i];
        HashMap<Long, Integer>[] dp = new HashMap[n];
        int sum = 0;
        for(int i = 0 ; i < n ; i ++){
            dp[i] =  new HashMap<>();
            for(int j = 0 ; j < i ; j++){
                long dest = longNum[i] - longNum[j];
                int count = dp[j].getOrDefault(dest, 0);
                dp[i].put(dest, dp[i].getOrDefault(dest, 0) + count + 1);
                sum += count;
            }
        }
        return sum;
    }
}
