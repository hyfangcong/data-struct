package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/7
 */
public class 新类型字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(process(scanner.next(), scanner.nextInt()));
        }
    }

    public static String process(String str, int k){
        String last = "";
        for(int i = 0 ; i < str.length(); ){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                last = str.substring(i,i+1);
                if(i == k)
                    return last;
                i++;
            }else{
                if(i == k){
                    return last;
                }
                if(i + 1 == k){
                    return str.substring(i, i + 2);
                }

                last = str.substring(i, i+2);
                i+=2;
            }
        }
        return null;
    }
}
