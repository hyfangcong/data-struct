package qz2019.weizhongyinhang;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while ((n & 0x80000000) == 0){
            n = n << 1;
            i ++;
        }
        int m = 32 - i +1;
        int sum = 1;
        int mod = 1000003;
        while (m >= 1){
            sum = sum * m;
            sum %= mod;
            m--;
        }
        System.out.println(sum);
    }

}
