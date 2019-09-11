package nkw.zsjinjie.beibao;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/7
 */
public class 背包0_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] value = new int[n+1];
        int[] weight = new int[n+1];
        for(int i = 1; i <= n ; i ++){
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        System.out.println(solution(value, weight,c));
    }


    public static int solution(int[] value, int[] weight, int c){
        int[] dp = new int[c+1];
        int n = value.length;
        for(int i = 1; i < n; i ++){
            for(int j = c; j >= weight[i]; j--){
                dp[j] = dp[j] > dp[j-weight[i]] + value[i] ? dp[j] : dp[j-weight[i]] + value[i];
            }
            for(int k = 1; k <= c ; k ++){
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        return dp[c];
    }
}
