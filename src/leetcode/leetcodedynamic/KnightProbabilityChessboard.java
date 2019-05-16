package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/15
 */
public class KnightProbabilityChessboard {
    public static void main(String[] args) {
        KnightProbabilityChessboard tt = new KnightProbabilityChessboard();
        System.out.println(tt.knightProbability(8,30,6,4));
    }

    private int[][] dir = {{1,2},{1,-2},{2,1},{2, -1}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
    public double knightProbability(int N, int K, int r, int c) {
        //数据量大的时候需要用long或者double
        double[][][] dp = new double[N][N][K + 1];

        /**
         * 给dp附上一个初始值，容易判断减枝
         */
        for(double[][] t : dp){
            for(double[]  a : t){
                Arrays.fill(a, -1);
            }
        }
        double sum = dfs(N, K, r, c, dp);
        return sum / Math.pow(8, K);
    }

    /**
     * dfs + 记忆化搜索（减枝）
     */
    private double dfs(int N, int k, int r, int c, double[][][] dp){
        if(r < 0 || r >= N || c < 0 || c >= N)
            return 0;
        if(k == 0)
            return 1;

        if(dp[r][c][k] != -1)
            return dp[r][c][k];
        double sum = 0;
        for(int[] di : dir){
            sum += dfs(N, k - 1, r + di[0], c + di[1], dp);
        }
       return dp[r][c][k] = sum;
    }
}
