package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 区间表达 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        for(int i = 0 ; i < n - 1;  i++) {
            if(arr[i + 1] - arr[i] != 1)
                sum++;
        }
        System.out.println(sum + 1);
    }
}
