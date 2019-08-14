package qz2019.wangyi.time81;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/11
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for(int i = 0; i < q; i ++){
            boolean flag = true;
            int sum = 0;
            int height = scanner.nextInt();
             for(int j = 0; j < n; j++){
                while(arr[j] > height){
                    j++;
                }
            }
        }
    }
}
