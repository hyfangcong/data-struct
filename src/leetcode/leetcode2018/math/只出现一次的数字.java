package leetcode.leetcode2018.math;

public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length ; i ++){
            res = res ^ nums[i];
        }
        return res;
    }
}
