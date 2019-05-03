package leetcode.leetcodedynamic;

public class 爬楼梯 {
    /**
     * 暴力递归,时间复杂度为O（2^n）,超出时间限制
     */
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 记忆化搜索,动态规划
     */
    public int climbStairs2(int n){
       if(n <= 2)
           return n;
       int dp1 = 1, dp2 = 2, dp = 0;
       for(int i = 3; i <= n ; i ++){
           dp = dp1 + dp2;
           dp1 = dp2;
           dp2 = dp;
       }
       return dp;
    }
}
