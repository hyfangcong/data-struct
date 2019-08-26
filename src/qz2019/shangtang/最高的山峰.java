package qz2019.shangtang;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/19
 */
public class 最高的山峰 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(helper(n, arr));
    }

    public static int helper(int n, int[] arr){
        if(n == 0){
            return 0;
        }
        int res = 0;
        int i = 0;
        for(; i+1 < n && arr[i+1] < arr[i];){
            i++;
        }
        for(; i < n-1; i++){
            if(i+1 < n && arr[i+1] > arr[i]){
                int l = i;
                for(; i+1 < n && arr[i+1] > arr[i];){
                    i++;
                }
                if(i==n-1){
                    break;
                }
                for(;i + 1 < n && arr[i+1] < arr[i];){
                    i++;
                }
                if(i-l+1 > res){
                    res = i-l+1;
                }
            }
        }
        return res;
    }
}
