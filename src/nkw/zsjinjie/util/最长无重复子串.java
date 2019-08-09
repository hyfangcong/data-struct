package nkw.zsjinjie.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class 最长无重复子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(maxSub(s));
            System.out.println(solution(s));
        }
    }

    /**
     * 这个算法的时间复杂度为O（n^2）
     * @param s
     * @return
     */
    public static int maxSub(String s){
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 1;
        int max = 0;
        set.add(s.charAt(0));
        for(; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                max = Math.max(max, right - left);
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }else{
                set.add(s.charAt(right));
            }
        }
        return Math.max(max, set.size());
    }


    /**
     * 用map记录字符出现的位置
     * pre为窗口的左端
     * 时间复杂度为O(n)
     */
    public static int solution(String s){
        if(s == null || s.length() == 0)
            return 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int max = 0;
        int left = -1;
        for(int i = 0; i < s.length() ; i++){
            left = Math.max(left, map[s.charAt(i)]);
            max = Math.max(max, i - left);
            map[s.charAt(i)] = i;
        }
        return max;
    }
}
