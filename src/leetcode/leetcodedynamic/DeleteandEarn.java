package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class DeleteandEarn {
    /**
     * 桶思想：由于操作次数是无限的，因此总是可以把该数字的所有个数都拿完。
     * 我们可以使用桶来装该数字的和。你选择一个桶，就需要放弃与该桶相邻的两个桶。
     *
     * 类似于打家劫舍，不能偷相邻的两个房子。
     *
     * 这里对于每个桶，有两种不同的选择，take or skip
     *
     * 递推关系： take：前一个桶必须是skip，后一个桶也必须是skip
     *            take = skip + sum
     *            skip: 前后桶是take和skip都可以
     *            skip = max(skip, take)
     */
    public int deleteAndEarn(int[] nums) {
        int[] sums = new int[100001];
        for(int num : nums)
            sums[num] += num;

        int take = 0, skip = 0;
        for(int sum : sums){
            int takei = skip + sum;
            int skipi = Math.max(take, skip);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
