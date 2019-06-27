package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 疯狂队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n - 1];
        int diff = max - min;
        int minIndex = 1;
        int maxIndex = n - 2;
        while(minIndex < maxIndex){
            diff += max - arr[minIndex];
            diff += arr[maxIndex] - min;
            min = arr[minIndex++];
            max = arr[maxIndex--];
        }

        //如果是偶数，max - arr[minIndex] == arr[maxIndex] - min = 0
        diff += Math.max(max - arr[minIndex], arr[maxIndex] - min);
        System.out.println(diff);
    }
}
