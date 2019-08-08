package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j ++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(minPathSum(matrix));
    }


    public static int minPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                if(i == 0 && j == 0){
                    dp[i][j] = matrix[i][j];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1] + matrix[i][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j] + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
