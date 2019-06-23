package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/29
 */
public class 盈利计划 {

    public static void main(String[] args) {
        int[] group = {2,3,5};
        int[] profiles = {6,7,8};
        int result = profitableSchemes(10,17, group, profiles);
        System.out.println(result);
    }

    /**
     * 背包问题
     * dp[i][j] 表示成员数为j，利润至少为i的可行的方案数
     *
     * 状态转移方程：
     * dp[i + p][j + g] += dp[i][j] if i+p < P
     *
     * dp[P][j + g] += dp[i][j] if j + p >= P
     *
     * 边界条件： dp[0][0] = 1;
     *
     * 这里使用二维就可以进行状态的转换了，因为，下一行只依赖与上一行的左上边部分。因此我们从右下角遍历即可
     * 使用二维代替三维。
     */

    public static int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        int res = 0, mod = (int)1e9 + 7;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], profile = profit[k];
            for (int i = P; i >= 0; i--)
                for (int j = G - g; j >= 0; j--)
                    dp[Math.min(i + profile, P)][j + g] = (dp[Math.min(i + profile, P)][j + g] + dp[i][j]) % mod;
        }
        for (int x : dp[P]) res = (res + x) % mod;
        return res;
    }
}
