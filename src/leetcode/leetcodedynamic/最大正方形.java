package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int j = n - 1; j >= 0 ; j --){
            for(int i = 0; i < m ; i ++){
                if(matrix[i][j] == '1')
                    dp[i][j] = j + 1 < n ? dp[i][j + 1] + 1: 1;
            }
        }

        int res = 0;
        for(int j = n - 1; j >= 0; j --){
            for(int beginRow = 0; beginRow < m ; beginRow ++){
                int high = dp[beginRow][j];

                for(int endRow = beginRow; endRow < m && dp[endRow][j] != 0;){
                    high = high < dp[endRow][j] ? high : dp[endRow][j];

                    while(endRow < m && dp[endRow][j] >= high)
                        endRow++;

                    int val = Math.min(high, endRow - beginRow);
                    res = res > val * val ? res : val * val;
                }
            }
        }
        return res;
    }
}
