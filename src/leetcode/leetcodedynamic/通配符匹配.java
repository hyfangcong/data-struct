package leetcode.leetcodedynamic;

public class 通配符匹配 {
    static int count = 0;

    public static boolean isMatch(String s, String p) {
        return match3(s, p);
    }

    //暴力求解，简单递归，时间超时,时间复杂度O(2^n)
    public static boolean match(String s, String p, int sIndex, int pIndex){
        count++;
        if(pIndex >= p.length()){
            return sIndex == s.length();
        }


        if(sIndex <= s.length() && p.charAt(pIndex) == '*'){
            while(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*')
                pIndex++;
            return match(s, p, sIndex, pIndex + 1) || match(s, p, sIndex + 1, pIndex);
        }else{
            boolean p_match = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?');
            return p_match && match(s, p, sIndex + 1, pIndex + 1);
        }
    }


    /**
     * p.charAt[i] 和s中对应位置的字符比较
     *
     *               |--- 'a-z', 如果相等则继续，否则返回false
     *               |
     * p.chatAt[i] = |--- '?',   继续下一个比较
     *               |
     *               |--- '*',   1.代表空字符串  2.代表非空字符串（可以转化为空字符串）。
     *
     *
     * 把非空转换成空的条件太复杂，目前不知道怎么包含所有的情况。这种方案不可行。
     */

    public static boolean match2(String s, String p, int sIndex, int pIndex){
        if(pIndex >= p.length())
            return sIndex == s.length();

        if(pIndex == p.length() - 1 && p.charAt(pIndex) == '*')
            return true;

        if(p.charAt(pIndex) == '*'){
            while(pIndex + 1< p.length() && p.charAt(pIndex + 1) == '*')
                pIndex++;

            if(pIndex + 1 < p.length()){
                    while(sIndex < s.length() && pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '?'){
                        pIndex++;
                        sIndex++;
                    }

                    while(sIndex < s.length() && pIndex + 1 < p.length()){
                        if(p.charAt(pIndex + 1) == '*')
                            break;

                        if(s.charAt(sIndex) != p.charAt(pIndex + 1))
                            sIndex++;
                        else
                            break;
                    }
                    return match2(s, p, sIndex, pIndex + 1);
            }
            else
                return match2(s, p, sIndex, pIndex);
        }else{
            boolean p_match = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?');
            return p_match && match2(s, p, sIndex + 1, pIndex + 1);
        }
    }

    /**
     *
     * 动态规划
     */
    public static boolean match3(String s, String p){
        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
        //s和p都为空字符串时，s与p匹配
        dp[0][0] = true;
        for(int i = 0 ; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j - 1) == '*'){
                    //'*'匹配0个或者匹配s.charAt(i - 1)字符
                    //‘*'不匹配m[i - 1][j - 1],是由于*可能匹配d
                    dp[i][j] = dp[i][j - 1]  || ( i > 0 && dp[i - 1][j]);
                }else{
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "*bb*****";
        System.out.println(isMatch(s, p));
        System.out.println(count);
    }
}
