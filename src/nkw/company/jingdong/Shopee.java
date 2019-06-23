package company.jingdong.j2019;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/22
 */
public class Shopee {
    public static void main(String[] args) {
        System.out.println(find());
    }

    public static long find(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m+1][n+1];
        long[][] dp = new long[m+1][n+1];
        int len = scanner.nextInt();
        for(int i = 0 ; i < len; i ++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[x][y] = 1;
        }

        for(int i = 0; i <= m; i ++){
            for(int j = 0; j <= n; j ++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else if(i == 0 && j != 0){
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i][j - 1];
                }else if(i != 0 && j == 0){
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i - 1][j];
                }else{
                    dp[i][j] = arr[i][j] == 1 ? 0 : dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
