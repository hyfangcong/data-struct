package nkw.cxymszn;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class 行列排好序的矩阵中找到k {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0 ; j < n ; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        int row = 0, col = n-1;
        while (true){
            if(row == m || col < 0){
                System.out.println("No");
                return;
            }
            if(matrix[row][col] > k){
                col--;
            }else if(matrix[row][col] < k){
                row++;
            }else {
                System.out.println("Yes");
                return;
            }
        }
    }
}
