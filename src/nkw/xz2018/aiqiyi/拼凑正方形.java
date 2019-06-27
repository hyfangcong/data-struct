package nkw.xz2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 拼凑正方形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0; i < 4; i ++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int min = arr[0], max = arr[3];
        int res = Integer.MAX_VALUE;
        for(int i = min; i <= max; i ++){
            int sum = 0;
            for(int j = 0; j < 4; j ++){
                sum += Math.abs(arr[j] - i);
            }
            res = Math.min(res, sum);
        }
        System.out.println(res);
    }
}
