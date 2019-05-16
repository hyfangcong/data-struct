package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/15
 */
public class MaximumSum3NonOverlappingSubarrays {
    public static void main(String[] args) {

    }

    /**
     * The question asks for three non-overlapping intervals with maximum sum of all 3 intervals.
     *If the middle interval is [i, i+k-1], where k <= i <= n-2k, the left interval has to be in subrange [0, i-1],
     * and the right interval is from subrange [i+k, n-1].
     *
     * So the following solution is based on DP.
     *    posLeft[i] is the starting index for the left interval in range [0, i];
     *    posRight[i] is the starting index for the right interval in range [i, n-1];
     *
     * Then we test every possible starting index of middle interval, i.e. k <= i <= n-2k,
     * and we can get the corresponding left and right max sum intervals easily from DP. And the run time is O(n).
     */
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return null;

        int n = nums.length;
        int[] sums = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[3];
        int max = 0 ;
        for(int i = 0 ; i < n  ; i ++){
            sums[i + 1] = sums[i] + nums[i];
        }

        //left -> right，使用了动态规划
        int leftMax = sums[k] - sums[0];
        left[k - 1] = 0;
        for(int i = k ; i < n ; i++){
            int tmp = sums[i + 1] - sums[i + 1 - k];
            if(tmp > leftMax){
                leftMax = tmp;
                left[i] = i + 1 - k;
            }else
                left[i] = left[i - 1];
        }

        //right -> left  使用了动态规划
        int rightMax = sums[n] - sums[n - k];
        right[n - k] = n - k;
        for(int i = n - k - 1 ; i >= 0 ; i --){
            int tmp = sums[i + k] - sums[i];
            if(tmp >= rightMax){
                rightMax = tmp;
                right[i] = i;
            }else
                right[i] = right[i + 1];
        }

        //now consider the middle part where k<=i<=n-2k ， 遍历每一种所有情况
        for(int i = k ; i <= n - 2*k; i ++){
            int l = left[i - 1];
            int r = right[i + k];
            int total = sums[l + k] - sums[l] + sums[i + k] - sums[i] + sums[r + k] - sums[r];
            if(total > max){
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}
