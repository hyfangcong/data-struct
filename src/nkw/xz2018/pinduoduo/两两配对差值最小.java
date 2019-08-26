package nkw.xz2018.pinduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/26
 */
public class 两两配对差值最小 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;  i< n ; i++){
            arr[i] = scanner.nextInt();
        }
        dfs(arr, 0);
        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;
    public static void dfs(int[] arr, int index){
        if(index == arr.length){
            min = Math.min(min, helper(arr));
            return;
        }
        for(int i = index;  i < arr.length; i ++){
            swap(arr, i, index);
            dfs(arr, i+2);
            swap(arr, i, index);
        }
    }

    private static int helper(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length; i +=2){
            int tmp = arr[i]+arr[i+1];
            if(tmp > max){
                max = tmp;
            }
            if(tmp < min){
                min = tmp;
            }
        }
        return max - min;
    }

    public static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
