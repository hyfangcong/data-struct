package leetcode.leetcodedynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author: fangcong
 * @date: 2019/5/6
 */

/**
 * 用时少
 *
 * https://leetcode-cn.com/submissions/detail/18253277/
 *
 */
public class 拼接最大数 {
    public static void main(String[] args) {
        拼接最大数 tt = new 拼接最大数();
        int[] nums1 = {6,7,5};
        int[] nums2 = {4,8,1};
        int k = 3;
        int[] res = tt.maxNumber(nums1, nums2, k);

        for(int item : res){
            System.out.print(item + " ");
        }
    }
//将k个元素分配到给定的两个数组，通过遍历所有的情况，找到最大排序的数组。
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = {};
        for(int i = Math.max(0, k - n); i <= Math.min(k, m); i++){
            res = max(mergeArray(maxArray(nums1, i), maxArray(nums2, k - i)), res);
        }
        return res;
    }

    //比较两个数组的大小
    private int[] max (int[] nums1, int[] nums2){

        if(nums2.length == 0)
            return nums1;

        for(int i = 0 ; i < nums1.length; i ++){
            if(nums1[i] > nums2[i])
                return nums1;
            else if(nums1[i] < nums2[i])
                return nums2;
        }
        return nums1;
    }


    //贪心算法：在数组nums中求长度为k的最大子序列
    private int[] maxArray(int[] nums, int k){
        int rest = nums.length - k;
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            while(rest > 0 && result.size() > 0 && result.get(result.size() - 1) < num){
                result.remove(result.size() - 1);
                rest --;
            }
            result.add(num);
        }
        int[] res = new int[k];
        //其实这里已经保证了 0<= k <= nums.length
        for(int i = 0 ; i < Math.min(k, result.size()); i ++){
            res[i] = result.get(i);
        }
        return res;
    }


    //合并两个无序数组
    private int[] mergeArray(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m + n];
        int i , j;
        for(i = 0 , j = 0 ; i < m && j < n;){
            if(compareNum(nums1, nums2, i, j) > 0)
                res[i + j] = nums1[i++];
            else
                res[i + j] = nums2[j++];
        }

        while(i < m)
            res[i + j] = nums1[i++];

        while(j < n)
            res[i + j ] = nums2[j ++];

        return res;
    }


    //判断两个数组的大小
    private int compareNum(int[] nums1, int[] nums2, int start1, int start2){
        int m = nums1.length;
        int n = nums2.length;
        int maxIndex = Math.min(m - start1, n - start2);
        for(int i = 0 ; i < maxIndex; i ++){
            if(nums1[i + start1] > nums2[i + start2])
                return 1;
            else if(nums1[i + start1] < nums2[i + start2])
                return -1;
        }

        return m - start1 > n -start2 ? 1 : m - start1 > n - start2 ? 0 : -1;
    }
}
