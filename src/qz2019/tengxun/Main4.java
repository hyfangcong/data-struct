package qz2019.tengxun;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] sum = new long[n+1];
        long[] arr = new long[n+1];
        long tmp = 0;
        for(int i =1 ; i <= n;  i++){
            arr[i] = scanner.nextLong();
            tmp += arr[i];
            sum[i] = tmp;
        }
        long[][] dp = new long[n+1][n+1];
        for(int len = 0; len < n; len++ ){
            for(int i =  1; i <= n - len; i ++){
                int j = i+len;
                if(i == j){
                    dp[i][j] = arr[i];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        long max = Long.MIN_VALUE;
        for(int i = 1; i <= n; i ++){
            for(int j = i; j <= n; j ++){
                max = Math.max(max, dp[i][j]*(sum[j] - sum[i-1]));
            }
        }
        System.out.println(max);
    }
}
