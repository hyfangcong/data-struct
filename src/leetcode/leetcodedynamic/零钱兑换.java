package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/6
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        零钱兑换 tt = new 零钱兑换();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int res = tt.coinChange(coins, amount);
        System.out.println(res);
    }

    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        //Arrays.sort(coins);
        return coin(coins, amount);
    }

    //递归 + 记忆化搜索
    private int coin(int[] conis, int amount){
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        if(dp[amount] != 0)
            return dp[amount];

      int res = 0;
        for(int i = conis.length - 1 ; i >= 0; i --){
            int tmp = coin(conis, amount - conis[i]);
            if(tmp >= 0)
                res = res == 0 ? tmp + 1 : Math.min(res, tmp + 1);
        }
        dp[amount] = res == 0 ? -1 : res ;
        return dp[amount];
    }

    //贪心算法

    /**
     * 不满足贪心算法
     */
    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        int maxIndex = coins.length - 1;
        int count = 0;
        while(amount > 0 && maxIndex >= 0){
            if(amount >= coins[maxIndex]){
                count += amount / coins[maxIndex];
                amount = amount % coins[maxIndex];
                maxIndex--;
            }else
                maxIndex--;
        }
        return amount == 0 ? count : -1;
    }

    /**
     * 动态规划
     */
    public int coinChange3(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        for(int i = 0 ; i < coins.length ; i ++){
            if(coins[i] <= amount)
                dp[coins[i]] = 1;
        }

        for(int i = 1 ; i <= amount; i ++ ){
            for(int j = 0 ; j < coins.length; j ++){
                if( i - coins[j] > 0 && dp[i - coins[j]] != 0 ){
                    dp[i] = dp[i] == 0 ? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
