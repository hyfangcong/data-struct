package nkw.zsjinjie.util;

/**
 * @author: fangcong
 * @date: 2019/8/2
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 定义数组异或和的概念：
 * 数组中所有的数异或起来，得到的结果叫做数组的异或和
 * {1,2,3} 1^2^3=0
 *
 * 给定一个数组arr，你可以任意把arr分成很多不相容的子数组，你的目的是分出来的子数组中异或和为0的子数组最多。
 *
 * 返回分出来的子数组中，异或和为0的子数组最多是多少？
 *
 * 解法：
 *      1.dp[i]表示[0-i]可以划分的最多子数组异或和为0的划分
 *      2.那么这种划分时，最后一个以i结尾的子数组有两种情况：
 *          1）异或和不为0，那么dp[i] = dp[i-1]
 *          2) 异或和为0，那么dp[i] = dp[k-1] + 1, k为离i最近的一个异或和为0的子数组。
 *      3. dp[i] = max(dp[i-1], dp[k-1]+1)
 *
 *      4.k的位置求解：运用了{@link 累加和等于k的最长子串}中的思想。这里记xor为从[0-i]的异或和。
 *        那么k的出现的位置是最晚的xor[0-k-1] == xor[0-i]
 *
 */
public class 异或为零的最多子数组 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,1,3,0};
        System.out.println(mostXOR(arr));
    }

    public static int mostXOR(int[] arr){
        int xor = 0;
        int ans = 0;
        int[] dp = new int[arr.length];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < arr.length; i ++){
            xor ^= arr[i];
            if(map.containsKey(xor)){
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : dp[pre] + 1;
            }
            if(i > 0){
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            map.put(xor,i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
