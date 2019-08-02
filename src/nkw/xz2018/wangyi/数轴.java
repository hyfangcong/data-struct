package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/19
 */

/**
 * 分析问题的核心点，不断更新左边界和右边界，求出最小的距离
 */
public class 数轴 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
             arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int dist = arr[n-1] - arr[0];
        for(int i = 0 ; i < n-1; i ++){
            int right = Math.max(arr[i] + s, arr[n-1] -s);
            int left = Math.min(arr[i+1] - s, arr[0] + s);
            dist = Math.min(dist, right - left);
        }
        System.out.println(dist);
    }
}
