package nkw.xz2018.bytedance;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */
public class 传送门 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1 ; i <= n ; i ++){
            arr[i] = scanner.nextInt();
        }
        solution2(arr, n);
    }

    /**
     * 动态规划：
     *        传送只能向后传送。因此只有i-1访问偶数次的时候才能访问到i(把题目的意思理解充分，不只是传送，而且只能向后传送)
     *        递推关系式： dp[i] = dp[i - 1] + dp[i - 1] - dp[arr[i - 1]] + 1 + 1
     *             化简： dp[i] = 2 * dp[i - 1] - dp[arr[i - 1]] + 2
     * @param arr
     * @param n
     */
    public static void solution2(int[] arr, int n){
        int mod = 1000000007;
        long[] dp = new long[1002];
        for(int i = 2; i <= n + 1; i ++){
            dp[i] = 2 * dp[i - 1] - dp[arr[i - 1]] + 2;
            /**
             * 一定要加上mod
             */
            dp[i] = (dp[i] + mod) % mod;
        }
        System.out.println(dp[n + 1]);
    }


    /**
     * 直接将题意翻译成代码
     * @param arr
     */
    public static void solution1(int[] arr, int n){
        int[] visit = new int[n + 1];
        int sum = 0;
        int pos = 1;
        while (true){
            sum = (sum + 1) % 1000000007;
            if(visit[pos] == 0){
                visit[pos] = 1;
                pos = arr[pos];
            }else{
                visit[pos] = 0;
                pos++;
            }
            if(pos == n + 1)
                break;
        }
        System.out.println(sum);
    }
}
