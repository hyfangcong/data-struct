package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/14
 */
public class 抽牌 {
    /**
     * 递归暴力求解
     *
     * 每次选择：小明和小方都有两种可能的选择，因此组合起来就有4种。分别为：
     * 前前、前后、后前、后后
     *
     */
    public static double process(int[]arr, int l, int r, double p, double q, double pre_all, int sum){
        if(l == r){
            return pre_all * (sum+arr[l]);
        }
        if(r-1 == l){
            return p*pre_all*arr[l] + (1-p)*pre_all*arr[r];
        }


        return process(arr, l+2, r, p, q, pre_all*p*q, sum+arr[l])
                + process(arr, l+1, r-1, p, q, pre_all*p*(1-q), sum+arr[l])
                + process(arr, l+1, r-1, p, q, pre_all*(1-p)*q, sum+arr[r])
                + process(arr, l, r-2, p, q, pre_all*(1-p)*(1-q), sum+arr[r]);
    }

    /**
     *
     * 使用动态规划
     * dp[i][j]表示[i,j]中小明获得分数的期望
     *
     * 递推关系式就是上面的递归过程
     *
     * 边界条件: dp[i][i] = arr[i]  dp[i][i+1] = p*arr[i] + (1-p)*arr[r];
     */

    public static void solution(int[] arr, double p, double q){
        int length = arr.length;
        double[][] dp = new double[length][length];
//        for(int i = 0; i < length; i++){
//            dp[i][i] = arr[i];
//            if(i != length - 1)
//                dp[i][i+1] = p*arr[i] + (1-p)*arr[i+1];
//        }

        for(int  len = 0; len < length; len++){
            for(int i = 0; i < length-len; i ++){
                int j = i+len;
                if(i == j){
                    dp[i][j] = arr[i];
                }else if(j-i == 1){
                    dp[i][j] = p*arr[i] + (1-p)*arr[j];
                }else{
                    dp[i][j] = p*q*dp[i+2][j] + p*(1-q)*dp[i+1][j-1]+p*arr[i]
                            + (1-p)*q*dp[i+1][j-1] + (1-p)*(1-q)*dp[i][j-2] + (1-p)*arr[j];

                }
            }
        }
        System.out.printf("%.3f", dp[0][length-1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int P = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i< n ; i++){
            arr[i] = scanner.nextInt();
        }

        double p = P / 100.0;
        double q = Q / 100.0;
        solution(arr, p, q);
    }
}
