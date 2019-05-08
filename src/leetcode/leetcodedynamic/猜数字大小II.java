package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/7
 */
public class 猜数字大小II {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount2(4));
    }

    /**
     * 不是二分法，这样求的不是最小值
     */
    public static int getMoneyAmount(int n) {
        int money = 0;
        int low = 1,  right = n;
        while(low < right){
            int mid = low + (right - low) / 2;
            money += mid;
            low = mid + 1;
        }
        return money;
    }

    /**
     * 动态规划: 类似戳气球
     *
     * dp[i][j] = [i....j]中猜中数字的最小金额
     *
     * dp[i][j] = min(max(dp[i][x - 1], dp[x + 1][j]) + x, dp[i][j])
     *
     * 边界条件dp[i][i] = 0;
     * */
    public static int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n ; i >= 1 ; i --){
            for(int j = i ; j <= n; j ++){
                if(i == j)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int x = i ; x <= j ; x ++){
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][x - 1], dp[x + 1][j]) + x);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
