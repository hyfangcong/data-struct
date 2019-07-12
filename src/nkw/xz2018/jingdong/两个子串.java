package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */

/**
 * 要求满足条件的字符串最短，分析可知：最短的情况为s中每个字符都是相同的。
 *
 * 因此从 i=1，开始判断。地推关系式如下题
 *
 *
 * 优化：可以提前退出循环
 * int i ;
 * for( i = len - 1; i >=0 ; i--){
 *     String s1 = s.substring(0, i);
 *     String s2 = s.substring(len - i);
 *     if(s1.equals(s2)){
 *          String res = s + s.substring(i);
 *          break;
 *     }
 * }
 */
public class 两个子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        int left = 0;
        int right = 1;
        int count = 0;
        while(right < n){
            if(s.charAt(right) == s.charAt(left)){
                right ++;
                left++;
                count ++;
            }else{
                if(left == 0){
                    right++;
                }else{
                    left = 0;
                    count = 0;
                }
            }
        }
        System.out.println(s + s.substring(count));
    }
}
