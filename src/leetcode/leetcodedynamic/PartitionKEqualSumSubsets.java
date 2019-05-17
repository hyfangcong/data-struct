package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0 ;
        for (int num : nums)
            sum += num;
        if(k < 0 || sum % k != 0)
            return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, k, sum / k, 0, 0, 0, visited);
    }

    /**
     * 深度优先搜索，每次都以nums【i】开始，遍历数组，能否找到子序列和等于target。直到i >= len.退出循环。
     * 以nums【i】开始的所有可能都遍历了，没有等于target，接着从nums【i+ 1】开始。直到i + 1 >= len。 所有的情况都便利完成。
     * return false。
     *
     * 程序提前退出： k==1.表明找到了k个数组和等于target的子序列数组。
     *
     * 因为这里要找到K个，因此，每当找到一个数组的时候，就从nums【0】的位置开始程序。
     * nums【i】中的元素不能重复使用，用visited标识元素是否被使用过。
     */
    private boolean canPartition(int[] nums, int k, int target, int cur_sum, int cur_num, int pos, int[] visited){
        if(k == 1)
            return true;
        if(cur_sum > target)
            return false;
        if(cur_sum == target && cur_num > 0)
            return canPartition(nums, k -1, target, 0, 0, 0, visited);

        for(int i = pos;  i < nums.length ; i++){
            if(visited[i] == 0) {   //判断元素是否已经使用过
                visited[i] = 1;    // 标记nums【i】已经使用
                if(canPartition(nums, k, target, cur_sum + nums[i], cur_num++, i + 1, visited))
                    return true;
                visited[i] = 0;   // 程序执行到这一行，表明nums【i】不满足和等于target。重新表示nums【i】未被使用。
            }
        }
        return false;   // 包含元素nums【i】，从i 到 len的子数组中没有找到和为target的子序列。
    }
}
