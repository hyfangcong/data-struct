package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素II {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i ++){
            if(set.size() <= k){
                if(set.contains(nums[i]))
                    return true;
                set.add(nums[i]);
            }else{
                set.remove(nums[i - k - 1]);
                if(set.contains(nums[i]))
                    return true;
                set.add(nums[i]);
            }
        }
        return false;
    }
}
