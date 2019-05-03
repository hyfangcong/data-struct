package leetcode.leetcodedynamic;

public class 正则表达式匹配 {

    public static boolean isMatch(String s, String p) {
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        return match(schar, pchar, 0 , 0);
    }

    public static boolean match(char[] s, char[] p, int sIndex, int pIndex){
        if(pIndex >= p.length)
            return sIndex == s.length;

        //经典
        boolean p_match = sIndex < s.length && (s[sIndex] == p[pIndex] || p[pIndex] =='.');

        //在访问数组之前，一定要保证索引合法，不能越界。
        if(pIndex + 1 < p.length && p[pIndex + 1] == '*'){
            return match(s, p, sIndex, pIndex + 2) || (p_match && match(s, p, sIndex + 1, pIndex));
        }

        return p_match && match(s, p, sIndex + 1, pIndex + 1);
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "aa*";
        System.out.println(isMatch(s, p));
    }
}
