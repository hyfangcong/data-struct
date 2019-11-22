package qz2019.weizhongyinhang;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/19
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = 1;
        for(int i = 1; i <= n ; i ++){
            s *= i;
            while (s % 10 == 0){
                s /= 10;
            }
            s %= 1000;
        }
        System.out.println(s % 10);
    }
}
