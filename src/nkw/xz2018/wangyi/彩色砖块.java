package nkw.xz2018.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: fangcong
 * @date: 2019/6/25
 */
public class 彩色砖块 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length() ; i++){
            set.add(s.charAt(i));
        }
        if(set.size() > 2)
            System.out.println(0);
        else
        System.out.println(set.size());
    }
}
