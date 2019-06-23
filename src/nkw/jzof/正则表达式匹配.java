package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */

/**
 * *表示前面的字符可以出现0次或者多次
 *
 * 1.pattern的第二个字符是'*',
 *
 * 2.pattern的第二个字符不是'*'
 */
public class 正则表达式匹配 {
    public static void main(String[] args) {
        String str = "";
        String pattern = "";
        System.out.println(match(str.toCharArray(), pattern.toCharArray()));
    }

    public static boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null)
            return false;

        return helper(str,0, pattern, 0);
    }

    private static boolean helper(char[] str, int sIndex, char[] pattern, int pIndex){
        /**
         * 要以模式的长度为判断标准
         */
        if(pIndex == pattern.length){
            return sIndex == str.length;
        }

        /**
         * sIndex最多只会进行+1，因此 sIndex != str.length <===> sIndex < str.length
         */
        if(pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*'){
            if((sIndex != str.length && (pattern[pIndex] == '.' || pattern[pIndex] == str[sIndex]))){
                return helper(str, sIndex + 1, pattern, pIndex) || helper(str, sIndex, pattern, pIndex + 2);
            }else
                return helper(str, sIndex, pattern, pIndex + 2);
        }else{
            if(pattern[pIndex] == '.' || (sIndex < str.length && pattern[pIndex] == str[sIndex])){
                return helper(str, sIndex + 1, pattern, pIndex + 1);
            }else
                return false;
        }
    }
}
