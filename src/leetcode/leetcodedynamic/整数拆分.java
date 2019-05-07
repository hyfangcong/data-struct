package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/6
 */
public class 整数拆分 {
    /**
     * 方法一：找规律法。每个被乘数都和3有关，如果不足3的，就是2，4
     * 即，一个数如果大于5则必须要拆，如果小于5，就不用再拆了。
     * 边界为：dp[2] = 1, dp[3] = 2, dp[4] = 4;
     *
     * 例如：10=3*3*4；11=3*3*3*2；12=3*3*3*3；
     *
     */

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n ; i ++){
            for(int j = 1; j <= i ; j ++){
                dp[i] = max(j * (i - j),dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

    private static int max(int a, int b, int c){
        int max = a > b ? a : b;
        return max > c ? max : c;
    }
}
