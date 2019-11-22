package qz2019.pingduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/25
 */
public class 字典 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        f(n,m,k,"");
    }

    static int count = 0;
    private static void f(int n, int m, int k, String s) {
        if(k == count){
            System.out.println(s);
            return;
        }
        if(n > 0){
            count++;
            f(n-1, m, k,s+"a");
        }
        if(m > 0){
            count++;
            f(n, m-1,k, s+"b");
        }
    }
}
