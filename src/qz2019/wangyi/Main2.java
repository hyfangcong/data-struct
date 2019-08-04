package qz2019.wangyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        for(int i = 0 ; i < q; i ++){
            int x = scanner.nextInt();
            int sum = 0;
            for(int j = 0; j < n; j ++){
                if(arr[j] >= x){
                    arr[j]--;
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
