package util;

/**
 * @author: fangcong
 * @date: 2019/8/15
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        int[] arr3 = {2,2,2,2,3,3,3,3};
        int[] arr4 = {4,1,6,3,9,11,1};
        int[] arr5 = {3,2,1,4,5,1,2,3,7,9};
        mergeSort(arr1, 0 , arr1.length-1);
        mergeSort(arr2, 0, arr2.length-1);
        mergeSort(arr3, 0, arr3.length-1);
        mergeSort(arr4, 0, arr4.length-1);
        mergeSort(arr5, 0, arr5.length-1);
        for(Integer i : arr1){
            System.out.print(i+" ");
        }
        System.out.println();
        for(Integer i : arr2){
            System.out.print(i+" ");
        }
        System.out.println();
        for(Integer i : arr3){
            System.out.print(i+ " ");
        }
        System.out.println();
        for(Integer i : arr4){
            System.out.print(i + " ");
        }
        System.out.println();
        for(Integer i : arr5){
            System.out.print(i + " ");
        }
        System.out.println();


    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            helper(arr,left, mid, right);
        }
    }

    private static void helper(int[] arr, int left, int mid, int right) {
        int[] arrTmp = new int[arr.length];
        int p = mid+1;
        int index = 0;
        while(left <= mid && p <= right){
            if(arr[left] < arr[p]){
                arrTmp[index++] = arr[left++];
            }else{
                arrTmp[index++] = arr[p++];
             }
        }
        while(left <= mid){
            arrTmp[index++] = arr[left++];
        }
        while(p <= right){
            arrTmp[index++] = arr[p++];
        }
        while(index > 0){
            arr[right--] = arrTmp[index-1];
            index--;
        }
    }
}
