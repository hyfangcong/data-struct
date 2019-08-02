package nkw.zsjinjie.util;

/**
 * @author: fangcong
 * @date: 2019/8/2
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组中存在正数，0，负数。 给定一个目标值k，求数组中最长连续子数组等于k的值，如果不存在返回-1
 *
 * 碰到子数组，子串问题时：
 * 子串必定要以一个位置结束，那么我们考虑以每个位置为结束，就可以考虑到所有的情况
 *
 * 解法：1.sum为0-i上的累加和， 我们找到最早出现和为sum-k的位置j，那么j-i就为一个结果
 *      2.用max记录最终结果，max = Math.max(max, j-i)
 *      3.如果sum是第一次出现，那么就把它记录到Map中
 *
 *
 * 变形：数组中只有奇数和偶数，求子数组中奇数和偶数相等的最长子数组。
 *      将奇数记为1，偶数记为-1. k = 0
 *
 *      数组中包含0，1，2三种数，求子数组中含有1和2的数量相同的最长子数组
 *
 *      0-0， 1-1 2-（-1）
 */
public class 累加和等于k的最长子串 {
    public static void main(String[] args) {
        int[] arr = {7,3,2,1,1,7-6,-1,7};
        System.out.println(maxLength(arr, 7));
    }

    public static int maxLength(int[] arr, int k){
        int sum = 0;
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0 ; i < arr.length; i ++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                max = Math.max(i-map.get(sum-k)+1, max);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }
}
