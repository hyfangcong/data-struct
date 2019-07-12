package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 求幂 {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //a==c的情况
        long result = (n * n + n * (n - 1)) % mod;

        //a != c a!=1 c != 1
        for(int i = 2; i * i <= n; i ++){
            result = (result + n / i ) % mod;
        }
        System.out.println(result);
    }
}
