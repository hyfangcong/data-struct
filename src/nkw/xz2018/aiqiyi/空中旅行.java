package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 空中旅行 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int feul = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int i;
        for( i = 0; i < n ; i++){
            if(feul >= arr[i]){
                feul -= arr[i];
            }else
                break;
        }
        System.out.println(i);
    }
}
