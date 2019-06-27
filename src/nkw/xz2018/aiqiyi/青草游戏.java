package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */

/**
 * 找规律
 */
public class 青草游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i ++){
            int num = scanner.nextInt();
            int x = num % 5;
            if(x == 1 || x == 3 || x == 4)
                System.out.println("niu");
            else
                System.out.println("yang");
        }
    }
}
