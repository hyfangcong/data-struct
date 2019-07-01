package nkw.xz2018.bytedance;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/1
 */

/**
 * 切入的角度不同，算法的设计就完全不同。
 *
 * 以区间的最小值的角度切入，对于每个最小值只需要遍历一遍数据即可。
 * 并且区间中的数据的范围时有限的[0-100],远小于数据的规模大小
 *
 * 这里的最小的数据集可以用题目中给定的数据集。也可以进行优化。
 * 对于每一个具体的数据输入，我们可以找到一个对应的最小值的数据集
 *
 * {@link nkw.xz2018.aiqiyi.幸运子序列}
 */
public class 最小数乘区间和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }

        int res = 0;
        for(int i = 100; i > 0; i--){
            int sum = 0;
            for(int j = 0; j < n; j ++){
                if(arr[j] >= i){
                    sum += arr[j];
                }else{
                    res = Math.max(res, sum * i);
                    sum = 0;
                }
            }
        }
        System.out.println(res);
    }
}
