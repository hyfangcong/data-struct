package nkw.xz2018.aiqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 删除重复字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            if(!set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
                set.add(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
