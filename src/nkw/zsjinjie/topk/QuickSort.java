package nkw.zsjinjie.topk;

/**
 * @author: fangcong
 * @date: 2019/8/1
 */

/**
 * 利用分治的思想，最好的情况是每次都将数组分为相等的两半，时间复杂度为O(N)
 *
 * 最坏的情况是，每次只会将数组分为1 和 n-1，时间复杂度为O(N^2)
 *
 * 基于概率的平均时间复杂度为O（n）
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {2,4,5,1,7,4,8,0};
        int[] arr2 = {4,2,4,4,4,5};
        System.out.println(quickSort(arr2, 0, arr2.length-1, arr2.length - 3));
    }


   public static int quickSort(int[] arr, int left, int right, int k){
       if(left < right){
           int mid = partation(arr, left, right);
           if(mid == k){
               return arr[mid];
           }else if(mid < k){
               return quickSort(arr, mid + 1, right, k);
           }else{
               return quickSort(arr, left, mid -1, k);
           }
       }
       return -1;
   }

    private static int partation(int[] arr, int left, int right) {
       int tmp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= tmp){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] < tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }
}
