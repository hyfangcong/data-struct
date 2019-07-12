package nkw.xz2018.souhu;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/2
 */

/**
 * 区间动态规划。
 * dp[i][j]:表示[i,j]区间中经过插入操作变成回文后的最小数组和
 *
 * 区间动态规划：循环不是从i开始，而是从j-i开始。j-i表示区间的大小
 *
 * 这里不能用中心扩展法：因为两边的状态不确定。以x为中心的左右两边的状态选取和剩余的部分的状态有关
 */
public class 回文数组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i ++){
            arr[i] = scanner.nextInt();
            dp[i][i] = arr[i];
        }

        for(int len = 2; len <= n ; len ++){
            for(int k = 0; k + len <= n ; k ++){
                int i = k, j = k + len -1;
                if(arr[i] == arr[j])
                    dp[i][j] = 2 * arr[i] + dp[i+1][j-1];
                else{
                    dp[i][j] = Math.min(2*arr[i] + dp[i+1][j], 2*arr[j] + dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
