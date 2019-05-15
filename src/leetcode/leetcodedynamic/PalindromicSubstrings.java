package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/14
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaaa"));
    }

    /**
     * dp[i][j]表示[i ... j]以i和j结尾的字串是否是回文串
     *
     * 递推关系： dp[i][j] = j - i < 2 || (i + 1 < n && j - 1 >=0 dp[i + 1][j - 1]) if s[i] == s[j]
     *
     * 边界条件：dp[i][j] = true, if i == j
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        if(n < 2)
            return n;
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int j = 0 ; j < n; j ++){
            dp[j][j] = true;
            for(int i = 0 ; i <= j ; i ++){
                if(s.charAt(i) == s.charAt(j)){
                   dp[i][j] = j - i < 2 || (i + 1 < n && j - 1 >= 0 && dp[i + 1][j - 1]);
                   res += dp[i][j] ? 1 : 0;
                }
            }
        }
        return res;
    }

    /**
     * 中心扩展法
     *
     * 比动态规划要快，因为他每次可以移动两个位置
     */
    public int countSubstrings2(String s) {
        for(int i = 0 ; i < s.length() ; i++){
            extendToCenter(s, i , i); // odd length
            extendToCenter(s, i, i + 1); // even length
        }
        return count;
    }
    //static int count = 0, 在leetcode中不能通过。
    int count = 0;
    private void extendToCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
    }
}
