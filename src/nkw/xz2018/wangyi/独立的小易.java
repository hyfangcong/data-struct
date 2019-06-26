package nkw.xz2018.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/26
 */
public class 独立的小易 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int f = scanner.nextInt();
        int d = scanner.nextInt();
        int p = scanner.nextInt();

        if(d / x > f){
            System.out.println(f + (d - x*f) / (x + p));
        }else
            System.out.println(d / x);
    }
}
