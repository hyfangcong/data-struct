package qz2019.qianxin;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/9
 */
public class 最近公共祖先 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int layer = scanner.nextInt();
        int n = (int)(Math.pow(2,layer)-1);
        int[] arr = new int[n];
        for(int i = 0 ;  i< n; i ++){
            arr[i] = scanner.nextInt();
        }
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        if(check(arr, p, 0) && check(arr, q, 0))
            System.out.println(f(arr, p, q, 0));
        else
            System.out.println(-1);
    }

    private static int f(int[] arr, int p, int q, int index){
        if(index >= arr.length || arr[index] == -1)
            return -1;
        if(arr[index] > p && arr[index] < q)
            return arr[index];

        if(arr[index] < p && arr[index] < q ){
            return f(arr, p, q, index*2+2);
        }

        if(arr[index] > p && arr[index] > q){
            return f(arr, p, q, index*2+1);
        }
        return -1;
    }

    private static boolean check(int[]arr, int key, int index){
        if(index >= arr.length || arr[index] == -1)
            return false;
        if(arr[index] == key)
            return true;
        if(arr[index] > key)
            return check(arr, key, 2*index+1);
        if(arr[index] < key)
            return check(arr, key, 2*index+2);
        return false;
    }
}
