package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 子数组的最大累加和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxSubSum(arr));
    }


    public static int maxSubSum(int[] arr){
        int sum = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i ++){
            sum += arr[i];
            max = Math.max(sum, max);
            if(sum < 0){
                sum=0;
            }
        }
        return max;
    }
}
