package leetcode.leetcodedynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/5/7
 */
public class 和为K的数组 {

    /**
     * 暴力解法：穷举所有可能
     */
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int[] sums = new int[nums.length];
        for(int i = 0 ; i < sums.length; i ++){
            if(i == 0)
                sums[0] = nums[0];
            else
                sums[i] = sums[i - 1] + nums[i];
        }

        int count = 0;
        for(int i = 0 ; i < sums.length ; i ++){
            for(int j = 0 ; j <= i; j ++){
                if(j == 0 && sums[i] == k){
                    count++;
                }else if(j > 0 && sums[i] - sums[j - 1] == k)
                    count++;
            }
        }
        return count;
    }

    /**
     扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
     时间复杂度为O(n)
     **/

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int result = 0;
        for(int i = 0 ;i < nums.length ; i++){
            sum += nums[i];
            if(map.containsKey(sum - k))
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
