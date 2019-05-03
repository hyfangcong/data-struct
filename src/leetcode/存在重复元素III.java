package leetcode;


import java.util.*;

public class 存在重复元素III {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 9, 1, 5, 9};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling(((long)nums[i] - t)) != null &&  set.ceiling(((long)nums[i] - t)) <= (long)nums[i] + t)
                return true;
            set.add((long) nums[i]);
            if (set.size() == k + 1)
                set.remove((long) nums[i - k]);
        }
        return false;
    }
}
