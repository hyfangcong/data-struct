package qz2019.huawei;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/7
 */
public class 魔法技能 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int tmp = m <= 3 ? 1 : f1(m);
        System.out.println(f2(n, m, tmp));
    }

    private static int f2(int n, int m, int tmp){
        int a = 1;
        int b = 1;
        if(m > n / 2){
            m = n - m;
        }
        for(int i = 1; i <= m; i++){
            a = (a*(n+1-i)) % mod;
            b = (b*i) % mod;
        }
        int ans = a / b;
        return (ans * tmp) % mod;
    }

    private static int f1(int m){
        int tmp = 1;
        for(int i = m -1 ; i > 2; i--){
            tmp = (tmp * i) % mod;
        }
        return tmp;
    }
}
