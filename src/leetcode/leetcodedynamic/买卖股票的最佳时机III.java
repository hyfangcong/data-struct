package leetcode.leetcodedynamic;

public class 买卖股票的最佳时机III {

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        int profit = maxProfit2(arr);
        System.out.println(profit);
    }


    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k+1][2];
        for(int i = 0; i < n; i ++){
            for(int k = max_k; k >= 1; k --){
                if(i == 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]);
            }
        }
        return n == 0 ? 0 : dp[n-1][max_k][0];
    }


    public int maxProfit(int[] prices) {

        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/

        int fstBuy = Integer.MIN_VALUE;
        int fstSell = 0;
        int secBuy = Integer.MIN_VALUE;
        int secSell = 0;
        for(int p : prices){
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }
}
