package leetcode.leetcodedynamic;

import java.util.Arrays;
import java.util.MissingFormatArgumentException;

/**
 * @author: fangcong
 * @date: 2019/5/11
 */
public class 自由之路 {
    /**
     * dp[i][j]表示转动得到key[0 ... i]中前i个字符所需要的最少的次数。j表示当前ring中的位置。并且ring[j] == key[i].
     *
     * 记录j的位置是因为此时j的位置就是12点钟，计算下一次的转动次数需要依赖此位置。
     *
     * 状态转移方程：dp[i][j] = min (dp[i][j], dp[i - 1][k] + min(abs(j - k), ring.length - abs(j - k)))
     * (从k位置转到j位置，顺时针转动的次数 + 逆时针转动的次数 = ring.length. 因此只需要计算一个方向上的转动次数，
     * 就可以得到另一个方向上的转动次数)
     *
     * 边界条件（初始状态）： dp[0][j] = min(j, ring.length - j)
     */
    public int findRotateSteps(String ring, String key) {
        char[] sring = ring.toCharArray();
        char[] skey = key.toCharArray();
        int[][] dp = new int[key.length()][ring.length()];
        for(int i = 0 ; i < dp.length ; i ++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int n = ring.length();
        int count = Integer.MAX_VALUE;
        for(int i = 0 ; i < skey.length ; i ++) {
            for(int j = 0 ; j < n; j ++){
                if(skey[i] == sring[j]){
                    if(i == 0)
                        dp[i][j] = Math.min(j, n - j);
                    else{
                        for(int k = 0 ; k < n ; k ++){
                            if(dp[i - 1][k] != Integer.MAX_VALUE){
                                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)));
                            }
                        }
                    }

                    if(i == skey.length - 1)
                        count = Math.min(count, dp[i][j]);
                }
            }
        }
        return count + skey.length;
    }
}
