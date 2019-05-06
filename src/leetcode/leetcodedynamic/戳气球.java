package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 戳气球 {

    /**
     * 递归 + 记忆化搜索
     *
     */
    private int[] nums2;
    private int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        nums2 = new int[nums.length + 2];
        nums2[0] = 1; nums2[nums.length + 1] = 1;
        for(int i = 1; i < nums2.length - 1; i++)
            nums2[i] = nums[i - 1];
        dp = new int[n + 1][n + 1];

        return dfs(1, nums.length);
    }

    private int dfs(int start, int end){
        if(start > end)
            return 0;

        if(dp[start][end] != 0)
            return dp[start][end];
        int middle, left, right;
        for(middle = start; middle <=end; middle++){
            left = dfs(start, middle - 1);
            right = dfs(middle + 1, end );

            dp[start][end] = Math.max(left + right + nums2[middle] * nums2[start - 1] * nums2[end + 1], dp[start][end]);
        }
        return dp[start][end];
    }

    public static void main(String[] args) {
        戳气球 tt = new 戳气球();
        int[] nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2};
        System.out.println(tt.maxCoins(nums));
    }
}
