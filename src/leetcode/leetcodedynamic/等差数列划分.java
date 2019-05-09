package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/8
 */
public class 等差数列划分 {
    /**
     * dp[i] 表示以i结尾的子数组是等差数列的个数。
     *
     * 由题意可知：这里的等差数组的元素是相邻的。
     */
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3)
            return 0;
        int[] dp = new int[n];
        int sum = 0;
        for(int i = 2 ; i < n ; i ++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
