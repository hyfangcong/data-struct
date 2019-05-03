package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            if(map.containsKey(find)){
                res[0] = i;
                res[1] = map.get(find);
            }else
                //尽可能的减少操作次数。如果数组中重复的元素很多，那么put操作就会少很多。
                map.put(nums[i],i);
        }
        return res;
    }
}
