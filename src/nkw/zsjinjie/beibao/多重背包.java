package nkw.zsjinjie.beibao;

import java.util.Scanner;


/**
 * @author: fangcong
 * @date: 2019/9/7
 */
public class 多重背包 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] value = new int[n+1];
        int[] weight = new int[n+1];
        int[] nums = new int[n+1];
        for(int i = 1; i <= n ; i ++){
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
            nums[i] = scanner.nextInt();
        }
        System.out.println(solution2(weight, value, nums, c));
    }

    private static int solution2(int[] weight, int[] value, int[] nums, int c){
        int n = weight.length;
        int[] dp = new int[c+1];
        for(int i = 1; i < n ;i ++){
            for(int j = c; j >= weight[i]; j --){
                for(int k = 1 ;  k < Math.min(j / weight[i], nums[i])+1; k++){
                    dp[j] = Math.max(dp[j], dp[j-k*weight[i]]+k*value[i]);
                }
            }

            for(int t = 1; t <= c; t++){
                System.out.print(dp[t]+" ");
            }
            System.out.println();
        }
        return dp[c];
    }

    private static int solution(int[] weight, int[] value, int[] nums, int c) {
        int n = weight.length;
        int[][] dp = new int[weight.length][c+1];
        for(int i = 1; i < weight.length; i ++){
            for(int j = weight[i]; j <= c; j ++){
                dp[i][j] = dp[i-1][j];
                for(int k = 1; k < Math.min(j / weight[i], nums[i]) + 1; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k*weight[i]] + k*value[i]);
                }
            }
            for(int t = 1; t <= c; t++){
                System.out.print(dp[i][t]+" ");
            }
            System.out.println();
        }
        return dp[n-1][c];
    }

}
