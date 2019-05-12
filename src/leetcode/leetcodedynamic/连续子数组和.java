package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/11
 */
public class 连续子数组和 {

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(checkSubarraySum(nums, 0));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)
            return false;
        int[] sums = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
            if(i == 0)
                sums[i] = nums[i];
            else
                sums[i] = sums[i - 1] + nums[i];  //sums[i]表示nums[0 .. i]之间的和

        for(int i = 0 ; i < nums.length - 1 ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                int sum;
                if(i == 0)
                    sum = sums[j];
                else
                    //[i ... j]之间的和为sums[j] - sums[i - 1]
                    sum = sums[j] - sums[i - 1];
                if ((sum == 0 && k == 0) || (k != 0 && sum % k == 0))
                    return true;
            }
        }
        return false;
    }
}
