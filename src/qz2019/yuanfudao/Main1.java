package qz2019.yuanfudao;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //次数
        int k = scanner.nextInt();  //k是人数
        int mod = 1000000007;

        long[][] dp = new long[n-1][2];
        dp[0][0] = 0;
        dp[0][1] = k-1;
        for(int i = 1; i < n-1; i ++){
            dp[i][0] = dp[i-1][1];
            long a = (dp[i-1][0] * (k-1)) % mod;
            long b = (dp[i-1][1] * (k-2)) % mod;
            dp[i][1] = (a+b) % mod;
        }
        System.out.println(dp[n-2][1]);
    }
}
