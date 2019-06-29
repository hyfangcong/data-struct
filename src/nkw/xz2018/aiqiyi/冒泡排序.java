package nkw.xz2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */

/**
 * 动态规划dp[i][j]表示：[i ... len)中经过j次反转操作后的逆序对的总数
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][k + 1];
        for(int i = n - 1; i >= 0; i --){
            for(int j = 0; j <= k; j ++){
                dp[i][j] = countReverseOrder(arr, i, i) + dp[i + 1][k];
                if(j > 0){
                    for(int p = i + 1; p < n; p ++){
                        int[] tmp = new int[p + 1];
                        System.arraycopy(arr,0,tmp,0,p + 1);
                        reverse(tmp, i, tmp.length - 1);
                        dp[i][j] = Math.min(dp[i][j], countReverseOrder(tmp, i, tmp.length - 1) + dp[p+1][j-1]);
                    }
                }
            }
        }
        System.out.println(dp[0][k]);
    }

    private static void reverse(int[] arr, int l, int r) {
        while(l < r){
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    private static int countReverseOrder(int[] arr, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i ++){
            for(int j = 0; j < i; j ++){
                if(arr[j] > arr[i])
                    sum++;
            }
        }
        return sum;
    }
}
