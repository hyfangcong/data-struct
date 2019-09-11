package leetcode.leetcodedynamic;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] prices = new int[n];
        for(int i = 0 ;  i < n;  i++){
            prices[i] = scanner.nextInt();
        }
        System.out.println(solution(prices));
        System.out.println();
        System.out.println(maxProfit(prices));
    }

    public static int solution(int[] prices){
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_pre_0 = 0;
        for(int i = 0 ;  i < prices.length; i ++){

            System.out.println(dp_pre_0+" " + dp_i_0 + " " + dp_i_1);

            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0-prices[i]);
            dp_pre_0 = tmp;
        }
        System.out.println(dp_pre_0+" " + dp_i_0 + " " + dp_i_1);
        return dp_i_0;
    }



    /**
     * sell[i]表示截至第i天，最后一个操作是卖时的最大收益；
     * buy[i]表示截至第i天，最后一个操作是买时的最大收益；
     * cool[i]表示截至第i天，最后一个操作是冷冻期时的最大收益；
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cool = new int[n];

        sell[0] = 0; buy[0] = -prices[0]; cool[0] = 0;
        for(int i = 1; i < n ; i ++){
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i]);
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
            cool[i] =Math.max(Math.max(cool[i - 1], buy[i - 1]), sell[i - 1]);
        }
        for(int i = 0 ;  i < n ; i ++){
            System.out.println(cool[i]+" "+buy[i] + " " + sell[i]);
        }
        return Math.max(Math.max(sell[n - 1], buy[n - 1]), cool[n - 1]);
    }
}
