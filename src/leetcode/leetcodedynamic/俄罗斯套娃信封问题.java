package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/6
 */
public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4}, {6,4},{6,7}, {2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }


    /**
     * 按照长度排好序后，在宽度上就转化成了最长上升子序列问题
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
        int max = 1;
        for(int i = 1; i < n ; i++){
            for(int j = 0 ; j < i ; j ++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    /**
     * 最长上升子序列的nlogn解法
     */
    public int maxEnvelopes2(int[][] envelopes) {
        int maxL = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));

        for(int[] env : envelopes) {
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < env[1])
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = env[1];
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }
}
