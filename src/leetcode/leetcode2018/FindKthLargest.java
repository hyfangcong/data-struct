package leetcode.leetcode2018;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        ((new FindKthLargest())).findKthLargest(arr,2);
    }

    public int findKthLargest(int[] nums, int k) {
        buildByArray(nums,k);
        for(int i = k ; i < nums.length ; i ++){
                replace(nums, i, k );
        }
        for(int i = 0 ; i < nums.length ; i++){
            System.out.println(nums[i]);
        }
        return nums[0];
    }

    private void add(int[] arr, int e, int index){
        arr[index] = e;
        while (index != 0){
            if(arr[(index - 1) / 2] > e){
                arr[index] = arr[(index - 1) / 2];
                arr[(index - 1) / 2] = e;
                index = (index - 1) / 2;
            }else{
                break;
            }
        }
    }

    private void replace(int[] arr, int index, int k){
        if(arr[0] < arr[index]){
            arr[0] = arr[index];
            siftdown(arr, 0, k);
        }
    }

    private void buildByArray(int[] arr, int k){
        for(int i = (k - 1) / 2; i >= 0; i --){
            siftdown(arr, i, k);
        }
    }

    private void siftdown(int[] arr, int index, int k){
        while(index * 2 + 1 < k){
            int i = index * 2 + 1;
            int temp = arr[index * 2 + 1];
            if(index * 2 + 2 < k && arr[index * 2 +2] < temp){
                i++;
                temp = arr[i];
            }
            if(arr[index] > temp){
                arr[i] = arr[index];
                arr[index] = temp;
                index = i;
            }else
                break;
        }
    }
}
