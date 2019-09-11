package qz2019.zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/8
 */
public class 解码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<String> res = f(s);
        for(int i = 0 ; i < res.size(); i ++){
            System.out.println(res.get(i));
        }
    }

    private static List<String> f(String s){
        if(s.length() == 0)
            return new ArrayList<>();
        int a = Integer.valueOf(s.substring(0,1));
        String first = "";
        List<String> left= new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(s.length() == 1 || s.charAt(1) != '0'){
            first = (char)('A'+a-1)+"";
            res = new ArrayList<>();
            left = f(s.substring(1));
            if(left.size() == 0){
                res.add(first);
            }
            for(int i = 0; i < left.size(); i ++){
                res.add(first+left.get(i));
            }
        }

        if(s.length() == 1)
            return res;

        int b = Integer.valueOf(s.substring(0,2));
        if(b > 26)
            return res;
        first = (char)('A'+b-1)+"";
        left = f(s.substring(2));
        if(left.size() == 0){
            res.add(first);
        }
        for(int i = 0; i < left.size(); i ++){
            res.add(first+left.get(i));
        }
        return res;
    }
}
