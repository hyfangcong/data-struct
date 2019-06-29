package nkw.xz2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */
public class 奶牛编号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        for(int i = 0; i < n ; i++){
            x[i] = scanner.nextInt();
        }
        Arrays.sort(x);
        long res = 1;
        int mod = 1000000007;
        for(int i = 0; i < n; i ++){
            res *= x[i] - i;
            res = res % mod;
        }
        System.out.println(res);
    }
}
