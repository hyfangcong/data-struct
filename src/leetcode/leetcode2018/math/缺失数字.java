package leetcode.leetcode2018.math;

public class 缺失数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length; i ++){
            res = res ^ nums[i] ^ (i + 1);
        }
        return res;
    }
}
