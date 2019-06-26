package nkw.xz2018.pinduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */

/**
 * 只需要最大三个数和最小的两个数，中间结果不用关心
 *
 * 整体考虑，忽略局部情况
 */
public class 最大乘积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i < n ; i ++){
            nums[i] = scanner.nextInt();
        }
        getLargestMul(nums, n);
    }

    private static void getLargestMul(long[] num, int n){
        long max1 = 0, max2 = 0, max3 = 0, min1 = 0, min2 = 0;
        for(int i = 0; i < n; i++){
            if(num[i] >= max1){
                max3 = max2;
                max2 = max1;
                max1 = num[i];
            }else if(num[i] >= max2){
                max3 = max2;
                max2 = num[i];
            }else if(num[i] > max3){
                max3 = num[i];
            }else if(num[i] <= min1){
                min2 = min1;
                min1 = num[i];
            }else if(num[i] < min2){
                min2 = num[i];
            }
        }
        System.out.println(Math.max(max1 * max2 * max3, max1 * min1 * min2));
    }
}
