package leetcode.leetcodedynamic;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/5/9
 */
public class 环绕字符串中的唯一的子字符串 {

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("cac"));
    }

    /**
     * dp[i] 表示p.charAt(i)结尾的子串的数量的最大值。
     */
    public static int findSubstringInWraproundString(String p) {
        if(p.length() < 2)
            return p.length();
        Map<Character, Integer> map  = new HashMap<>();
        int[] dp = new int[p.length()];
        dp[0] = 1;
        map.put(p.charAt(0), 1);
        int result = 1;
        for(int i = 1 ; i < p.length(); i ++){
            int diff = p.charAt(i) - p.charAt(i - 1);
            if(diff == 1 || diff == -25)
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;

            int last = map.getOrDefault(p.charAt(i), -1);

            //如果dp[i] > last, 那么将last替换成dp[i],加入到result中，并且更新map
            result += last == -1 ? dp[i] : dp[i] > last ? dp[i] - last : 0;
            map.put(p.charAt(i), Math.max(last, dp[i]));

        }
      return result;
    }
}
