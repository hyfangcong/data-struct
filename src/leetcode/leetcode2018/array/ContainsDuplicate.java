package leetcode.leetcode2018.array;

import java.util.TreeSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;

        TreeSet<Integer> set = new TreeSet<>();
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        set.add(arr[0]);
        for(int i = 1; i < nums.length; i++) {
            set.add(arr[i]);
        }
        return set.size() == nums.length ? false : true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        boolean res = (new ContainsDuplicate()).containsDuplicate(arr);
        System.out.println(res);
    }
}
