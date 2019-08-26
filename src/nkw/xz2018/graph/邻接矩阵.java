package nkw.xz2018.graph;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 邻接矩阵 {
    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        matrix = new int[n+1][n+1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n ;j ++){
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
