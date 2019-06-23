package data_struct.sort;

/**
 * @author: fangcong
 * @date: 2019/6/5
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        int[] arr3 = {2,2,2,2,3,3,3,3};
        int[] arr4 = {4,1,6,3,9,11,1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr1, 0 , arr1.length - 1);
        mergeSort.mergeSort(arr2, 0 , arr2.length - 1);
        mergeSort.mergeSort(arr3, 0, arr3.length - 1);
        mergeSort.mergeSort(arr4, 0, arr4.length - 1);

        for(int i = 0 ; i < arr1.length; i ++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < arr2.length; i ++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < arr3.length; i ++){
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < arr4.length; i ++){
            System.out.print(arr4[i] + " ");
        }
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid , right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temArr = new int[arr.length];
        int hi = mid + 1;
        int index = -1;
        while(left <= mid && hi <= right){
            if(arr[left] < arr[hi]){
                temArr[++index] = arr[left++];
            }else{
                temArr[++index] = arr[hi++];
            }
        }
        while(left <= mid){
            temArr[++index] = arr[left++];
        }
        while(hi <= right){
            temArr[++index] = arr[hi++];
        }

       while(index >= 0){
           arr[right --] = temArr[index--];
       }
    }
}
