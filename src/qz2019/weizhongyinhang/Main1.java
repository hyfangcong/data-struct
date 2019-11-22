package qz2019.weizhongyinhang;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/19
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(helper(n));
    }

    private static int helper(int n){
        if(n == 0 || n - 1 == 1){
            return 1;
        }

        int tmp = 1;
        for(int i = n; i > 0; i --){
            if(i % 10 == 0){
                i = i / 10;
                while (i % 10 == 0){
                    i = i / 10;
                }
            }
            tmp = tmp * (i % 10);
            if(tmp % 10 == 0){
                tmp = tmp / 10;
            }

            if(tmp > 10){
                tmp = tmp % 10;
            }
        }
        return tmp;
    }
}
