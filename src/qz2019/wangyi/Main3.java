package qz2019.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        for(int i = 0 ; i < time ; i++){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j = 0 ;  j< n ; j ++){
                arr[j] = scanner.nextInt();
            }
            System.out.println("YES");
        }
    }
}
