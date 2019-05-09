package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/8
 */
public class 分割数组的最大值 {

    /**
     *首先分析题意，可以得出结论，结果必定落在【max（nums）， sum（nums）】这个区间内，因为左端点对应每个单独的元素构成一个子数组，右端点对应所有元素构成一个子数组。
     *
     * 然后可以利用二分查找法逐步缩小区间范围，当区间长度为1时，即找到了最终答案。
     *
     * 每次二分查找就是先算一个mid值，这个mid就是代表当前猜测的答案，然后模拟一下划分子数组的过程，可以得到用这个mid值会一共得到的子区间数cnt，然后比较cnt和m的关系，来更新区间范围。
     *
     * 本题跟1014 875 非常类似。
     *
     */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }

        while(left < right){
            int mid = left + (right - left) /2;
            int cur = 0;
            int size = 1;
            for(int num : nums){
                if(cur + num > mid){
                    size ++;
                    cur = 0;
                }
                cur += num;
            }
            if(size > m)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
