package qz2019.shangtang;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/19
 */
public class 谈学姐投资 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long f0 = scanner.nextLong();
        int mod = 1000000007;
        int p = 32767;
        long f1 ,f2, f3;
        f1 = (a*f0 + 1 + p) % mod;
        f2 = (a*f1 + b*f0 + 6 + p) % mod;
        f3 = (a*f2 + b*f1 + c*f0 + 15+p) % mod;
        if(n == 0){
            System.out.println(f0);
            return;
        }
        if(n==1){
            System.out.println(f1);
            return;
        }
        if(n==2){
            System.out.println(f2);
            return;
        }
        for(long i = 3; i <= n; i++){
            f3 = (a*f2 + b*f1 + c*f0 + helper(i, mod) + p) % mod;
            f0 = f1;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);
    }

    public static long helper(long i, int mod){
        i %= mod;
        double a = (double)i;
        long b = (long)(2*Math.pow(i,2));
        return b - i;
    }
}
