package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/25
 */
public class 等差数列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i ++){
            num[i] = scanner.nextInt();
        }

        if(n <= 2) {
            System.out.println("Possible");
            return;
        }
        Arrays.sort(num);
        int step = num[1] - num[0];
        for(int i = 1; i < n - 1; i ++){
            if(step != num[i + 1] - num[i]){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
