package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/5
 */
public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,3};
        System.out.println(lengthOfLIS2(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = 1;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0)
                    dp[i] = Math.max(dp[i] , 1);
                else if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = max > dp[i] ? max : dp[i];
                }
            }
        }
        return max;
    }

    /**
     * O(nlogn)时间复杂度
     *
     *tails[i]是长度为 i+1的所有上升子序列中，结尾最小的那一个。
     *
     * 因此tails是一个递增数组，因此我们可以使用二分查找在tails中找到需要被更新的那个位置。
     *
     * 递推关系：
     * （1）如果 x > 所有的tails的值，tails[size] = x, tails的size + 1
     * (2) tails[i - 1] < x <= tails[i], tails[i] = x
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
