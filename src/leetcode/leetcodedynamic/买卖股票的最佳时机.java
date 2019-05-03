package leetcode.leetcodedynamic;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length - 1; i ++){
            for(int j = i + 1; j < prices.length; j ++){
                int val = prices[j] - prices[i];
                if(val > 0)
                    max = max > val ? max : val;
            }
        }
        return max;
    }


    /**
     * 动态规划：前i天的最大收益 = max(前i-1天的最大收益， 第i天的价格 - 前i天中最低的价格)
     */
    public int maxProfit2(int[] prices) {
        if(prices.length == 0)
            return  0;
        //去掉数组
        //int[] dp = new int[prices.length];
        int max = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i ++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
