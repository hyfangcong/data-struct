package nkw.xz2018.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/25
 */
public class 操作序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i ++){
            arr[i] = scanner.nextInt();
        }
        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }

        if(n % 2 == 0){
            for(int i = n - 1; i > 0; i -= 2){
                System.out.print(arr[i] + " ");
            }
            for(int i = 0; i < n - 2; i += 2){
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[n - 2]);
        }else{

            for(int i = n-1;i >= 0;i -= 2){
                System.out.print(arr[i] + " ");
            }
            for(int i = 1;i < n - 2;i += 2){
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[n-2]);
        }

    }
}
