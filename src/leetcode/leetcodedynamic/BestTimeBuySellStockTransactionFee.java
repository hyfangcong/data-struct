package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class BestTimeBuySellStockTransactionFee {
    /**
     * 记录每天买入和卖出的最大收益
     */
    public int maxProfit(int[] prices, int fee) {
        int t0 = 0 ;   //t0当天卖出股票
        int t1 = Integer.MIN_VALUE;  //t1当天买入股票
        for(int price : prices){
            int t0_old = t0;
            t0 = Math.max(t0, t1 + price);
            t1 = Math.max(t1, t0_old - price - fee);
        }
        return t0;
    }
}
