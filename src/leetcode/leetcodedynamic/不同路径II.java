package leetcode.leetcodedynamic;

public class 不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j != 0){
                    dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i][j - 1] : 0;
                }else if(j == 0 && i != 0){
                    dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] : 0;
                }else if (i != 0 && j != 0)
                    dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
                else
                    dp[i][j] = obstacleGrid[i][j] == 0 ? 1 : 0;
            }
        }
        return dp[m - 1][n  -1];
    }
}
