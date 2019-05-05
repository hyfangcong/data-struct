package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 地下城游戏 {

    /**
     * dp[i][j]表示（i，j）到右下角所需的最少血量
     *
     * 递推关系式： dp[i][j] = dungeon[i][j] > min(dp[i + 1][j], dp[i][j + 1]) ?
     *                         1 : min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
     *
     * 边界条件（基本子问题）：i = m - 1, j = n - 1;
     *                          dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : -dungeon[m - 1][n - 1] + 1;
     *
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0)
            return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1 ; j >= 0 ; j --){
                if(i == m - 1 && j == n - 1)
                    dp[i][j] = dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
                else if(i == m - 1)
                    dp[i][j] = dungeon[i][j] >= dp[i][j + 1] ? 1 : dp[i][j + 1] - dungeon[i][j];
                else if(j == n - 1)
                    dp[i][j] = dungeon[i][j] >= dp[i + 1][j] ? 1 : dp[i + 1][j] - dungeon[i][j];
                else
                    dp[i][j] = dungeon[i][j] >= Math.min(dp[i + 1][j], dp[i][j + 1]) ?
                                            1 : Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
            }
        }
        return dp[0][0];
    }
}
