package leetcode.leetcodedynamic;

public class 解码方法 {
    public static int numDecodings(String s) {
        decode(s, 0);
        return count;
    }


    /**
     * 暴击递归解法，时间复杂度为O（2^n）
     *
     * 题目类似斐波那契数列求和，只是这里是由条件限制的斐波那契数列求和
     */
    static int count = 0;
    private static void decode(String s, int index){
        if(index == s.length()){
            count++;
            return;
        }

        if(s.charAt(index) != '0')
            decode(s, index + 1);

        if(index + 2 <= s.length()){
            int two = Integer.parseInt(s.substring(index, index + 2));
            if(two<= 26 && two >= 10)
                decode(s, index + 2);
        }
    }

    /**
     * 动态规划求解
     */

    public static int numDecodings2(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i ++){
            if(s.charAt(i - 1) != '0')
                dp[i] = dp[i -1];

            if(i - 2 >= 0){
                int val = Integer.parseInt(s.substring(i - 2, i));
                if(val >= 10 && val <= 26)
                    dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings2("12"));
    }
}
