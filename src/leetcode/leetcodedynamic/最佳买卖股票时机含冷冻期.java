package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 最佳买卖股票时机含冷冻期 {

    /**
     * sell[i]表示截至第i天，最后一个操作是卖时的最大收益；
     * buy[i]表示截至第i天，最后一个操作是买时的最大收益；
     * cool[i]表示截至第i天，最后一个操作是冷冻期时的最大收益；
     */
    public int maxProfit(int[] prices) {
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
        return Math.max(Math.max(sell[n - 1], buy[n - 1]), cool[n - 1]);
    }
}
