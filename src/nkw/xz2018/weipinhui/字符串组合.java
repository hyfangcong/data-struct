package nkw.xz2018.weipinhui;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/7/1
 */
public class 字符串组合 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        List<TreeSet<String>> result = new ArrayList<>();
        for(int len = 1; len <= n ; len++){
            TreeSet<String> set = new TreeSet<>();
            for(int i = 0; i <= n - len; i ++){
                set.add(s.substring(i, i + len));
            }
            result.add(set);
        }
        for(int i = 0; i < result.size(); i ++){
            Iterator<String> iterator = result.get(i).iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
        }
    }
}
