package qz2019.zijietiaodong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
public class Main2 {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if(n == 2){
            System.out.println(1);
            return;
        }
        if(n==4){
            System.out.println(2);
            return;
        }
        long p = (long)(0.5 * n);
        p = n*p;
        p = p - (long)(2.5*n) + 2;
        System.out.println(p%mod);
    }
}
