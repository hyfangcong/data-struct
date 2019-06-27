package nkw.xz2018.aiqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class DNA序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        for(int i = 1; i <= n; i ++){
            Set<String> set = new HashSet<>();
            for(int j = 0; j < n - i; j ++){
                set.add(s.substring(j, j + i));
            }
            if(set.size() < Math.pow(4,i)){
                System.out.println(i);
                return;
            }
        }
    }
}
