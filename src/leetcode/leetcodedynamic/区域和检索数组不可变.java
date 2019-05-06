package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 区域和检索数组不可变 {
    int[] nums;
    int[][] dp;
//    public 区域和检索数组不可变(int[] nums) {
//        this.nums = nums;
//    }

    /**
     * 时间复杂度为O（n^2）
     *
     * dp[i][j] 表示[i...j](i <= j)的和
     */
    public int sumRange(int i, int j) {
        if(dp != null){
            return dp[i][j];
        }
        int len = nums.length;
        dp = new int[len][len];
        for(int col = 0 ; col < len; col ++){
            for(int row = 0 ; row <= col; row ++){
                if(row == col)
                    dp[row][col] = nums[row];
                else if(row == 0)
                    dp[row][col] = dp[row][col - 1] + nums[col];
                else
                    dp[row][col] = dp[row - 1][col] - nums[row - 1];
            }
        }
        return dp[i][j];
    }


    /**
     * 时间复杂度为O（n）
     *
     * res = sum[j] - sum[i - 1], sum[i] 为[0...i]之间的和
     */

    private int[] sums;

    public 区域和检索数组不可变(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i];
        }
    }

    public int sumRange2(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] sums = {};
        区域和检索数组不可变 tt = new 区域和检索数组不可变(sums);

    }
}
