package leetcode.leetcodedynamic;

import java.util.TreeSet;

/**
 * @author: fangcong
 * @date: 2019/5/7
 */
public class 矩形区域不超过K的最大数值和 {

    public static void main(String[] args) {
        int[][] matrix = {{5,-4,-3,4}, {-3,-4,4,5},{5,1,5,-4}};
        int[][] matrix2 = {{2,2,-1}};
        System.out.println(maxSumSubmatrix2(matrix, -2));
    }

    /**
     * 暴力求解：时间超时
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(j == 0)
                    dp[i][j] = matrix[i][j];
                else
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
            }
        }

        int res = Integer.MIN_VALUE;
        for(int row1 = 0 ; row1 < m ; row1++){
            for(int col1 = 0 ; col1 < n ; col1 ++){
                for(int row2 = row1; row2 < m ; row2 ++){
                    for(int col2 = col1; col2 < n ; col2 ++){
                        int tmp = 0;
                        for(int i = row1 ; i <= row2 ; i++){
                            if(col1 == 0)
                                tmp += dp[i][col2];
                            else
                                tmp += dp[i][col2] - dp[i][col1 - 1];
                        }
                        if(tmp <= k)
                            res = Math.max(res, tmp);
                        if(res == k)
                            return res;
                    }
                }
            }
        }
        return res;
    }



     // 参考560 + 340， 以及楼上大佬
     //
     // 用set保存之前的子矩阵的和sum，然后在set中找出 <=（sum - k）的最大值。
     //
     // 这里子矩阵求和参考了340解法，把矩阵按照列或者行转换成一维数组的和，然后在进行子矩阵求和
     //
     // 本题是按照列来转换的，总体的时间复杂度为O(n * n * m * n)
    // ps:（也可以按照行转换，时间复杂度为O（m * m * n * m）,由于测试用例中的行较多，结果超时了）

    public static int maxSumSubmatrix2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sums = new int[m][n];

        /**
         * 按照列来求和
         */
        for(int col = 0 ; col < n; col ++){
            for(int row = 0 ; row < m ; row ++){
                if(row == 0)
                    sums[row][col] = matrix[row][col];
                else
                    sums[row][col] = sums[row - 1][col] + matrix[row][col];
            }
        }

        /**
         * col1为矩阵起始列，col2为矩阵结尾列
         */
        int result = Integer.MIN_VALUE ;
         for(int col1 = 0 ; col1 < n ; col1 ++){
            for(int col2 = col1; col2 < n ; col2++){
                /**
                 * set中都是存放的是startCol和endCol相同的矩阵的和
                 */
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int row = 0 ; row < m ; row++){
                    int sum = 0;  //子矩阵的和
                    for(int i = col1; i <= col2 ; i ++){
                        sum += sums[row][i];
                    }

                    //求出set中小于等于（sum - k）最大值
                    if(set.ceiling(sum - k) != null){
                        int max = sum - set.ceiling(sum - k);
                        result = result > max ? result : max;
                    }
                    set.add(sum);
                }
            }
        }
        return result;
    }
}
