package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class 解码方法2 {
    /**
     * dp[i]表示[0...i]中的解码数
     *
     * dp[i] = dp[i - 1] * [第i个单独解码的个数] + dp[i - 2] * [第i-1 和第i一起解码的个数]
     *
     * 包含有这样的00 / 30 / 40 ...无法解码
     */

    public static void main(String[] args) {
        System.out.println(numDecodings("1*"));
    }
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return s.charAt(0) == '0' ? 0 : s.charAt(0) == '*' ? 9 : 1;
        if(s.charAt(0) == '0')
            return 0;

        char[] chars = s.toCharArray();
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '*' ? 9 : 1;
        for(int i = 2; i <= chars.length ; i ++){
            char first = chars[i - 2]; //表示第i - 1个字符
            char second = chars[i - 1]; //表示第i个字符

            //对于dp[i - 1]
            if(second == '*')
                dp[i] += 9 * dp[i - 1];
            else if(second > '0')
                dp[i] += dp[i - 1];

            //对于dp[i - 2]
            if(first == '*'){
                if(second == '*') {
                    dp[i] += 15 * dp[i - 2];
                }else if(second <= '6')
                    dp[i] += 2 * dp[i - 2];
                else
                    dp[i] += dp[i - 2];
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    dp[i] += first == '1' ? 9 * dp[i - 2] : 6 * dp[i - 2];
                }else if((first - '0') * 10 + second - '0' <= 26){
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= 1000000007;
        }
        return (int)dp[s.length()];
    }
}
