package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {

    //在[left...right)的区间中是一个维持没有重复字符的滑动窗口
    //当右边新加一个字符仍然满足，right++，扩大窗口，
    //当右边新加一个字符不满足没有重复字符，记录此时的窗口大小，left++，缩小窗口，恢复窗口是没有重复字符的。
    public static int lengthOfLongestSubstring(String s) {
        boolean[] contain = new boolean[256];
        int n = s.length();
        int left =0 , right = 0, max = 0;
        while(right < n){
            while(right < n && !contain[s.charAt(right)]){
                contain[s.charAt(right)] = true;
                right++;
            }

            max = Math.max(max, right - left);
            while(left < n && right < n){
                contain[s.charAt(left)] = false;
                if(s.charAt(left++) == s.charAt(right))
                    break;
            }
        }
        return max;
    }

    static final Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
//        int res =     lengthOfLongestSubstring("dedv");
//        System.out.println(res);

        String s = "a";
        System.out.println(s);
        s += "b";
        System.out.println(s);

    }
}
