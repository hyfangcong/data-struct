package nkw.xz2018.meituandianping;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 交错序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n ; i++){
            for(int j = i-1; j >= 0; j --){
                if(arr[i] != arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n ;i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
