package leetcode.leetcodedynamic;

public class 不同路径 {
    public int uniquePaths(int m, int n) {
        paths(m, n, 0 , 0);
        return count;
    }

    /**
     * 暴力递归，时间复杂度为O(2^n),时间超时
     */
    int count = 0;
    public void paths(int m, int n, int row, int col){
        if(row == m - 1 && col == n - 1)
            count++;

        if(row + 1 < m)
            paths(m, n , row + 1, col);

        if(col + 1 < n)
            paths(m, n, row , col + 1);
    }


    /**
     * 动态规划
     *
     * 递推表达式：dp[i][j] = dp[i - 1][j - 1]
     */
        public int uniquePaths2(int m, int n) {
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i ++){
                for(int j = 0 ; j < n; j ++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }

    /**
     * 直接使用组合算法
     * 机器人一共需要走m+n-2步， 其中向右需要走m - 1步， 向下需要走n- 1 步。因此有C(m+n-2, m -1)
     */

}
