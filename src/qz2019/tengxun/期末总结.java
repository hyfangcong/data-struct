package qz2019.tengxun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class 期末总结 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i =0 ; i < n;  i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int min = arr[0];
        int sum = arr[0];
        int minIndex = 0;
        for(int i = 1; i < arr.length; i ++){
            sum += arr[i];
            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
        }
        int max = min * sum;
        int[] left = Arrays.copyOfRange(arr, 0, minIndex+1);
        int[] right = Arrays.copyOfRange(arr, minIndex, arr.length);
        int l = getMax(left);
        int r = getMax(right);
        if(l > max){
            max = l;
        }
        if(r > max){
            max = r;
        }
        return max;
    }
}
