package nkw.xz2018.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/19
 */

/**
 * 动态规划：dp[i][j]:前i个骰子得分为j的方案数
 */
public class 骰子游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        long[][] dp = new long[25][150];
        if(n >= x){
            System.out.println(1);
            return;
        }
        if(x > n * 6){
            System.out.println(0);
            return;
        }
        for(int i = 1; i <=6 ; i ++)
            dp[1][i] = 1;          //一个骰子，分数为i的方案数
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= x ; j ++){
                for(int k = 1; k <=6 ; k ++){ //第i个骰子投的点数k
                    if(j - k < 0)  //j - k 为前i-i次投的点数
                        break;
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        long sum = 0;
        for(int i = 1; i < x; i ++){
            sum += dp[n][i];
        }
        long total = (long)Math.pow(6, n);
        long maxDivisor = gcd(total - sum, total);
        System.out.println((total-sum)/maxDivisor + "/" + total/maxDivisor);
    }

    public static long gcd(long a, long b){
        long tmp;
        while(b > 0){
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
