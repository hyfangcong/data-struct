package leetcode.leetcodedynamic;

public class 买卖股票的最佳时机IV {
    /**
     * 有III推广而来，用一个二维数组来记录，每笔买卖的最大收益
     */
    public int maxProfit(int k, int[] prices) {
        if(k < 1)
            return 0;

        if(k >= prices.length / 2)
            return greed(prices);

        int[][] trans = new int[k][2];
        for(int i = 0 ; i < k ; i ++)
            trans[i][0] = Integer.MIN_VALUE;

        for(int p : prices){
            trans[0][0] = Math.max(trans[0][0], -p);
            trans[0][1] = Math.max(trans[0][1], trans[0][0] + p);

            for(int i = 1; i < k ; i ++){
                trans[i][0] = Math.max(trans[i][0], trans[i - 1][1] - p);
                trans[i][1] = Math.max(trans[i][1], trans[i][0] + p);
            }
        }
        return trans[k - 1][1];
    }

    public int greed(int[] prices){
        int max = 0;
        for(int i = 1 ; i < prices.length; i ++){
            if(prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
