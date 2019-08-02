package nkw.zsjinjie.kmp;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/1
 */
public class 字符串匹配 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println(kmp(scanner.next(), scanner.next()));
        }
    }

    public static int kmp(String s, String p){
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return -1;
        }
        int[] next = getNext(p);
        int i = 0, j = 0;
        while(i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                if(j == -1){
                    i++;
                    j = 0;
                }else{
                    j = next[j];
                }
            }
        }
        return j == p.length() ? i - j : -1;
    }

    public static int[] getNext(String pattern){
        if(pattern == null || pattern.length() == 0)
            return null;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int k = -1, j = 1;
        while(j < pattern.length()){
            if(k == -1){ //前缀和后缀的最长匹配为0
                next[j++] = 0;
                k++;
                continue;
            }
            if(pattern.charAt(j-1) == pattern.charAt(k)){  //第一次进行这个条件判断的时候，k=next[j-1]
                k++;
                next[j++] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
