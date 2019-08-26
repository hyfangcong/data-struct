package qz2019.tengxun;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/17
 */
public class 压缩字符串 {
    static int index = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str == null || str.length() == 0){
            System.out.println("");
            return;
        }
        int n = str.length();
        String res = "";
        while (true){
            res += dfs(str, n);
            if(index == n)
                break;
            index++;
        }
        System.out.println(res);
    }

    public static String dfs(String str, int n){
        int p = index;
        while (index < n && str.charAt(index) >= 'A' && str.charAt(index) <= 'Z'){
            index++;
        }
        String tmp1 = str.substring(p, index);
        if(index == n){
            return tmp1;
        }
        int time = 0;
        String tmp2="";
        String mid="";
        if(str.charAt(index) == '['){
            int q = ++index;
            while(str.charAt(index) != '|'){
                index++;
            }
            time = Integer.valueOf(str.substring(q, index));
            index++;
            tmp2 = dfs(str, n);
        }
        if(str.charAt(index) == ']'){
            for (int i = 0; i < time; i++){
                mid += tmp2;
            }
        }
        return tmp1 + mid;
    }
}
