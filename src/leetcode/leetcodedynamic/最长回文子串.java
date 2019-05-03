package leetcode.leetcodedynamic;

public class 最长回文子串 {

    //暴力解法
    public static String longestPalindrome(String s) {
        String res = "";
        //i 代表子串的长度，从最长的开始，可以减少部分计算量
        for(int i = s.length() ; i > 0; i-- ){
            for(int j = 0 ; (j + i) <= s.length(); j ++){
                int l = j, r = j + i -1;
                while(l < r){
                    if(s.charAt(l) != s.charAt(r))
                        break;
                    l++;
                    r--;
                }
                if(l >=r)
                    return s.substring(j, j + i);
            }
        }
        return res;
    }

    //中心扩展法
    public static String longestPalindrome2(String s) {
        String res = "";
        for(int i = 0 ; i < s.length(); i ++){
            String temp = expentToCenter(s, i, i);
            res = res.length() >= temp.length() ? res : temp;
            temp = expentToCenter(s, i, i + 1);
            res = res.length() >= temp.length() ? res : temp;
        }
        return res;
    }

    public static String expentToCenter(String s , int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }
}
