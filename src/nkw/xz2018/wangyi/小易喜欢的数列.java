package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 小易喜欢的数列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        dy2(n, k);
    }

//    /**
//     * 递归，超时
//     */
//    static int sum = 0;
//    private static void helper(int num, int index, int n, int k) {
//        if(index == k - 1){
//            sum = (sum + 1) % 1000000007;
//            return;
//        }
//
//        for(int i = 1; i <= n; i++){
//            if(num <= i || num % i != 0){
//                helper(i, index+ 1, n, k);
//            }
//        }
//    }
//
//    /**
//     * 动态规划， 超时
//     *
//     */
//    public static void dy(int n, int k) {
//        int[][] dp = new int[n + 1][k + 1];
//        dp[0][1] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                for (int r = 1; r <= k; r++) {
//                    if (r <= j || r % j != 0)
//                        dp[i][j] = (dp[i][j] + dp[i - 1][r]) % 1000000007;
//                }
//            }
//        }
//        int result = 0;
//        for(int i = 1; i <=k ; i ++){
//            result = (dp[n][i] + result) % 1000000007;
//        }
//        System.out.println(result);
//    }


    /**
     * 求出长度为i的非法数列和invalid，i- 1的合法数列和sum
     *
     * 长度为i的合法数列和为sum - invalid
     */
    static final int mod = 1000000007;
    public static void dy2(int n, int k){
        int[][] dp = new int[n + 1][k + 1];
        dp[0][1] = 1;
        for(int i = 1; i <= n; i ++){
            int sum = 0;
            for(int j = 1; j <= k; j ++){
                sum = (sum + dp[i - 1][j]) % mod;
            }

            for(int j = 1; j <= k; j ++){
                int invalid = 0;
                int p = 2;
                while(p * j <= k){
                    invalid = (invalid + dp[i - 1][p * j]) % mod;
                    p++;
                }
                dp[i][j] = (sum - invalid + mod) % mod;
            }
        }

        int sum = 0;
        for(int i = 1; i <= k ; i++){
            sum = (sum + dp[n][i]) % mod;
        }
        System.out.println(sum);
    }
}
