package leetcode.leetcodedynamic;

import java.util.Arrays;

public class 不同子序列 {
    public int numDistinct(String s, String t) {
        /**
         * 为什么dp数组的长度为s.length() + 1 和 t.length() + 1？
         * 因为需要表示空字符串：即dp[0][j]:表示s为空字符串；    dp[i][0]:表示t为空字符串
         *
         * dp[i][j] 表示s[0...i -1]中子序列与t[0...j - 1]前j个字符相匹配的个数
         */
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //初始化，当t为空时，s的子序列为t只有一种情况，即dp[i][0] = 1;
        //当t为非空，s为空时，不存在这样的子序列，即dp[0][j] = 0(j != 0)
        for(int i = 0; i <= s.length(); i ++)
            dp[i][0] = 1;

        for(int i = 1 ; i <= s.length(); i ++){
            for(int j = 1 ; j <= t.length() ; j ++){
                dp[i][j] = dp[i - 1][j];
                if(s.charAt(i-1) == t.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[s.length()][t.length()];
    }

    /**
     * 用时2ms，击败99%的用户
     *
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct4(String s, String t) {
        // dp[0]表示空串
        int[] dp = new int[t.length() + 1];
        // dp[0]永远是1，因为不管S多长，都只能找到一个空串，与T相等
        dp[0] = 1;

        //t的字典
        int[] map = new int[128];
        Arrays.fill(map, -1);

        //从尾部遍历的时候可以遍历 next类似链表 无重复值时为-1，
        //有重复时例如从rabbit的b开始索引在map[b] = 2 next[2] 指向下一个b的索引为3
        // for (int j = t.length() - 1; j >= 0; j--) {
        //     if (t.charAt(j) == s.charAt(i)) {
        //        dp[j + 1] += dp[j];
        //     }
        // }
        //这段代码的寻址就可以从map[s.charAt(i)] 找到索引j 在用next[j] 一直找和 s.charAt(i)相等的字符 其他的就可以跳过了
        //所以这个代码的优化 关键要理解 上面的一维倒算
        int[] nexts = new int[t.length()];
        for(int i = 0 ; i < t.length(); i++){
            int c = t.charAt(i);
            nexts[i] = map[c];
            map[c] = i;
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = map[c]; j >= 0; j = nexts[j]){
                dp[j + 1] += dp[j];
            }
        }
        return dp[t.length()];
    }
}
