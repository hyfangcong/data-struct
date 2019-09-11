package nkw.xz2018.bytedance;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/5
 */
public class 聪明的编辑 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ;  i< n ;  i++){
            String s = scanner.next();
            System.out.println(process(s));
        }
    }

    private static String process(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int pre=0, cur=0;
        for(int i = 0; i < n;  i++){
            if( i == 0){
                cur++;
                sb.append(s.charAt(i));
            }else{
                if(s.charAt(i) != s.charAt(i-1)) {
                    pre = cur;
                    cur = 1;
                    sb.append(s.charAt(i));
                }else{
                    if(pre == 2){
                        continue;
                    }else if(cur == 2){
                        continue;
                    }else{
                        sb.append(s.charAt(i));
                        cur++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
