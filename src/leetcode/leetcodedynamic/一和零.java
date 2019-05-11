package leetcode.leetcodedynamic;

import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/10
 */
public class 一和零 {
    /**
     * 0 - 1 背包问题（只不过有两个背包）
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0 ; i < strs.length ;  i++){
            int zero = 0 ;
            int one = 0;
            String s = strs[i];
            /**
             * 在很多循环的情况下， 每个循环中对应的索引不要搞混淆了
             *
             * 如果这样的话，就会出现死循环了
             */
            for(int j = 0 ; j < s.length(); j ++ ) {

                /**
                 * 在进行判断的时候，一定要注意比较的双方是什么类型
                 *
                 * 特别注意：字符串比较要使用equals（）
                 *
                 *            char要带上''
                 */
                if(s.charAt(j) == '0')
                    zero++;
                else
                    one++;
            }

            for(int k = m; k >= zero ; k --){
                for(int p = n; p >= one ; p --){
                    /**
                     * 对于多维数组，索引很多的时候，不要高错了
                     *
                     */
                    dp[k][p] = Math.max(dp[k][p], dp[k - zero][p - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] ss = {"10","0001","111001","1","0"};
        System.out.println(findMaxForm(ss, 5, 3));
    }
}
