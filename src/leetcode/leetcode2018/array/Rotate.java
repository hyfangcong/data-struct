package leetcode.leetcode2018.array;

public class Rotate {
    public void rotate(int[] nums, int k) {
        while(k > 0){
            int temp = nums[nums.length - 1];
            for(int i = nums.length - 2; i >= 0; i--){
                nums[i + 1] = nums[i];
            }
            nums[0] = temp;
            k--;
        }
    }

    public void rotate2(int[] nums, int k){
        k %= nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0, k -1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7};
//        (new Rotate()).rotate(arr,3);
        (new Rotate()).rotate2(arr,3);
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.println(arr[i]);
        }
    }
}
