package leetcode.leetcode2018.array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int index = 0;
        int sum = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[index]) {
                sum--;
                if(sum == 0){
                    index = i;
                    sum++;
                }
            }else
                sum++;
        }
        return nums[index];
    }
}
