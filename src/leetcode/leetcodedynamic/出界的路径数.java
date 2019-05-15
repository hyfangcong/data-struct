package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class 出界的路径数 {

    public static void main(String[] args) {
        System.out.println(findPaths(8,50,23,5,26));




    }
    static long[][][] dp;
    public static int findPaths(int m, int n, int N, int i, int j) {
        dp = new long[m][n][N + 1];
        for(int x = 0 ; x < m ; x ++){
            for(int y = 0 ; y < n ; y ++){
                Arrays.fill(dp[x][y], - 1);
            }
        }
        return (int) findPaths(m, n, N, 0, i, j );
    }

    /**
     * 递归 + 记忆化搜索（dfs + 记忆化搜索）
     *
     * 在判断边界条件的时候：
     * step等于多少的时候，移动的次数就超过了N？
     * 列举法： step = 1 ----- 移动1次
     *          step = 2 ----- 移动2次
     *          ...
     *          step = n ----- 移动n次
     *
     * 因此可以得到： step > N 的时候，移动次数超过了N，应该返回0
     */
    private static long findPaths(int m , int n , int N, int step, int i , int j ){
        if(step > N)
            return 0;
        if(i < 0 || i == m || j < 0 || j == n)
            return 1;

        if(dp[i][j][step] != -1)
            return dp[i][j][step];

        long sum1 = findPaths(m, n , N, step+ 1, i - 1, j);
        long sum2 = findPaths(m, n , N, step + 1, i + 1, j);
        long sum3 = findPaths(m, n , N , step + 1, i, j - 1);
        long sum4 = findPaths(m, n, N , step + 1, i, j + 1);
        return dp[i][j][step] = (long)((sum1 + sum2 + sum3 + sum4) % (1e9 + 7));
    }
}
