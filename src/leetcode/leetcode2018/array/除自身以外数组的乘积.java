package leetcode.leetcode2018.array;

public class 除自身以外数组的乘积 {

    //时间复杂度为O(n^2),空间复杂度为O(1),因为输出数组不算空间复杂度
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i ++){
            int sum = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j)
                    sum *= nums[j];
            }
            res[i] = sum;
        }
        return res;
    }

    //时间复杂度O(n), 空间复杂度O(n)
    public int[] productExceptSelf2(int[] nums) {
        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];

        int left = 1, right = 1;
        for(int i = 0; i < leftArr.length; i++){
            leftArr[i] = left;
            left *= nums[i];
        }

        for(int j = rightArr.length - 1; j >= 0 ; j --){
            rightArr[j] = right;
            right *= nums[j];
        }

        int[] output = new int[nums.length];
        for(int k = 0 ; k < output.length; k ++){
            output[k] = leftArr[k] * rightArr[k];
        }
        return output;
    }

    //时间复杂度O(n), 空间复杂度O(1)
    public int[] productExceptSelf3(int[] nums) {
        int[] output = new int[nums.length];

        int left = 1, right = 1;
        for(int i = 0 ; i < output.length ; i ++){
            output[i] = left;
            left *= nums[i];
        }

        for(int j = output.length - 1; j >= 0 ; j--){
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }

}
