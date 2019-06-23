package company.jingdong.j2019;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 建物流中转站 {
    public static void main(String[] args) {
        System.out.println(buildStation());
    }
    public static int buildStation(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    min = Math.min(min, dest(i, j, matrix));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int dest(int x, int y, int[][] matrix) {
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j ++){
                if(matrix[i][j] == 1){
                    res += Math.abs(i - x) + Math.abs(j - y);
                }
            }
        }
        return res;
    }
}
