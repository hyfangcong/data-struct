package leetcode;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));


    }

    //可以使用数组来代替HashMap进行优化
    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character,Integer> tMap = new HashMap<>();
        int arr [] = new int[256];
        for(int i = 0 ; i < n; i ++){
            arr[t.charAt(i)] += 1;
        }

        //在[left...right)区间中，如果此区间没有包含T中所有的字符，那么区间右边向前移动，扩大区间，即right++
        //如果此区间包含T中所有字符，那么区间左边向前移动，缩小区间，即left++，找到最小值
        int left = 0, right = 0, count = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while(left < m && right < m ){
            while(right < m && count < n){
                char cRight = s.charAt(right);
                if(arr[cRight]-- > 0)
                    count++;
                right++;
            }

            while(count == n && left < m){
                if(min > right - left){
                    min = right - left;
                    res = s.substring(left, right);
                }
                char cLeft = s.charAt(left);
                if(arr[cLeft]++ >= 0)
                    count--;
                left++;
            }
        }
        System.out.println(min);
        return res;
    }
}
