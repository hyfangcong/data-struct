package leetcode.leetcodedynamic;

import java.util.List;

/**
 * @author: fangcong
 * @date: 2019/5/4
 */
public class 单词拆分 {
    /**
     * 将原问题转化为更小的子问题：s[0...n] = s[0...n-1] + s.sub(n - 1, n) 或者 s[0...n-2] + s.sub(n - 2, n) ...
     * 空串 + s[0...n]
     *
     * 只需判断s[0...n-1]是否可以拆分为wordDict，以及s.sub(n - 1, n)是否在wordDict中
     *
     * 基本子问题：空字符串可以拆分为wordDict
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxLen = Integer.MIN_VALUE;
        for(String item : wordDict)
            maxLen = maxLen > item.length() ? maxLen : item.length();

        for(int i = 1 ; i <= n; i++){
            /**
             * j的取值范围可以优化，不用每次都从0开始取值，j = max(0, i - maxLen); maxLen是wordDict中单词的最大长度
             */
            for(int j = Math.max(0, i - maxLen); j < i ; j ++){
               if(dp[j] && wordDict.contains(s.substring(j, i)))
                   dp[i] = true;
            }
        }
        return dp[n];
    }
}
