package qz2019.chubao;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/22
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ss = scanner.next().split("]|\\[|,| ");
        int n = Integer.valueOf(scanner.next());
        int[] arr = new int[3];
        for(int i = 1; i < ss.length; i ++){
            arr[i-1] = Integer.valueOf(ss[i]);
        }
        System.out.println(change(n, arr));
    }

    public static int change(int n, int[] arr){
        int[] dp = new int[n+1];
        dp[0] = 1;
        int len = arr.length;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= n; j++){
                if(j -arr[i-1] >= 0){
                    dp[j] += dp[j - arr[i-1]];
                }
            }
        }
        return dp[n];
    }
}
