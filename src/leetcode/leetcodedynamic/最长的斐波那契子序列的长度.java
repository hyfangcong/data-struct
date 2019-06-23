package leetcode.leetcodedynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/18
 */
public class 最长的斐波那契子序列的长度 {
    /**
     * dp[a, b] represents the length of fibo sequence ends up with (a, b)
     * Then we have dp[a, b] = (dp[b - a, a] + 1 ) or 2
     *
     */
    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> index = new HashMap<>();  //值 -- pos。（利用值找pos，因为数组是严格递增的）
        for (int j = 0; j < A.length; j++) {
            index.put(A[j], j);
            for (int i = 0; i < j; i++) {
                int k = index.getOrDefault(A[j] - A[i], -1);
                dp[i][j] = (A[j] - A[i] < A[i] && k >= 0) ? dp[k][i] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}
