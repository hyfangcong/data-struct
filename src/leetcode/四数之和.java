package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> res = fourSum(nums, 0);
        for(List<Integer> list : res){
            for(int i = 0 ; i < list.size(); i++)
                System.out.print(list.get(i));
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i ++){
            int newTarget = target - nums[i];
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < nums.length - 2 ; j ++){
                int newTarget2 = newTarget - nums[j];
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int l = j + 1, r = nums.length - 1;
                while(l < r){
                    int temp_sum = nums[l] + nums[r];
                    if(temp_sum > newTarget2){
                        r --;
                    }else if(temp_sum < newTarget2)
                        l ++;
                    else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1])
                            l ++;
                        while( l < r && nums[r] == nums[r - 1])
                            r --;
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
