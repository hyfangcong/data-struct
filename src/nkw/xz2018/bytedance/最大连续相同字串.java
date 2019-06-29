package nkw.xz2018.bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/29
 */

/**
 *
 * 连续区间问题可以使用滑动窗口
 */
public class 最大连续相同字串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[] chars = scanner.next().toCharArray();
        int l = 0, r = 0, max = 0, an = 0, bn = 0;
        while(r < n){
            if(chars[r] == 'a')
                an++;
            else
                bn++;
            if(an <=m || bn <= m){
                r++;
            }else{
                max = max > r - l ? max : r - l;
                if(chars[l++] == 'a')
                    an--;
                else
                    bn--;
                r++;
            }
        }
        max = max > r - l ? max : r - l;
        System.out.println(max);
    }
}
