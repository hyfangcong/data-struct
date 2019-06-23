package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/18
 */
public class MinimumNumberRefuelingStops {

    public static void main(String[] args) {
        MinimumNumberRefuelingStops tt = new MinimumNumberRefuelingStops();
        int[][] stations = {{10,100}};
        System.out.println(tt.minRefuelStops(100, 1, stations));
    }

    /**
     * dp[t] means the furthest distance that we can get with t times of refueling.
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //范围越界了，不能使用int[]
       long[] dp = new long[stations.length + 1];
       dp[0] = startFuel;
       for(int i = 0; i < stations.length; ++i){
           for(int t = i ; t >=0 && dp[t] >= stations[i][0] ; --t){
               dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
           }
       }
       for(int i = 0 ; i < dp.length ; i ++){
           if(dp[i] >= target)
               return i;
       }
       return -1;
    }


}
