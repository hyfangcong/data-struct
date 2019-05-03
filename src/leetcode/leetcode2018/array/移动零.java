package leetcode.leetcode2018.array;

public class 移动零 {

    public static void main(String[] args) {
        int [] arr = new int[]{0,1,0,3,12};
        (new 移动零()).moveZeroes(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
    }

    public void moveZeroes(int[] nums) {
        if(nums != null){
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] == 0){
                    continue;
                }
                int j = i - 1;
                while(j >= 0){
                    if(nums[j] == 0){
                        swap(nums, j, i);
                        break;
                    }else
                        j--;
                }
                if(j <= 0)
                    break;
            }
        }
    }

    private void swap(int[] arr, int left, int right){
        for(int i = left + 1; i <= right; i++){
           arr[i - 1] = arr[i];
        }
        arr[right] = 0;
    }
}
