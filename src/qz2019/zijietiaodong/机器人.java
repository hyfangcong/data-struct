package qz2019.zijietiaodong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/8
 */
public class 机器人 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i  < n;  i++){
            arr[i] = scanner.nextInt();
        }
        f(arr);
        if(index == -1)
            System.out.println(0);
        else
            System.out.println(arr[index]);
    }

    static int index = -1;
    static int max = 0;
    public static void f(int[] arr){
        for(int i = 0; i < arr.length-1; i ++){
            int midMax = 0;
            int sum = 0;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > arr[i])
                    break;
                if(arr[j] >= midMax && midMax < arr[i]){
                    midMax = arr[j];
                    sum++;
                }
            }
            if(sum > max){
                max = sum;
                index = i;
            }
        }
    }
}
