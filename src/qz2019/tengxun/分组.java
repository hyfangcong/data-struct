package qz2019.tengxun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/20
 */
public class 分组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            t--;
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }
            f(arr, n, sum);
        }
    }
    private static void f(int[] arr, int n, int sum) {
        Arrays.sort(arr);
        int fire1 = 0;
        int fire2 = 0;
        int count = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            int size = n - j + i + 1;
            count += arr[i];
            size--;

            if(count < sum / 2){
                count += arr[j];
                size++;
            }

            if (count >= sum / 2) {
                i++;
            } else {
                i++;
                j--;
            }
            if (size == n / 2) {
                fire1 = Math.min(count, sum - count);
                fire2 = Math.max(count, sum - count);
                break;
            }
        }
        System.out.println(fire1 + " " + fire2);
    }
}
