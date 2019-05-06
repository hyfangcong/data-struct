package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 区域和检索矩阵不可变 {

    /**
     * 参照上一题：把二维转化成一维，然后在sumRegion中进行合并
     */
    private int [][] sums;
    public 区域和检索矩阵不可变(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        sums = new int[m][n];

        for(int i = 0 ; i < m ; i ++){
            sums[i][0] = matrix[i][0];
            for(int j = 1; j < n ; j ++){
                sums[i][j] = sums[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 == 0)
                res += sums[i][col2];
            else
                res += sums[i][col2] - sums[i][col1 - 1];
        }
        return res;
    }
}
