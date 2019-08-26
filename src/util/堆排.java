package util;

import static nkw.xz2018.jingdong.第二大的数.swap;

/**
 * @author: fangcong
 * @date: 2019/8/15
 */
public class 堆排 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        int[] arr3 = {2,2,2,2,3,3,3,3};
        int[] arr4 = {4,1,6,3,9,11,1};
        int[] arr5 = {3,2,1,4,5,1,2,3,7,9};
        heapSort(arr1);
        heapSort(arr2);
        heapSort(arr3);
        heapSort(arr4);
        heapSort(arr5);
    }


    public static void heapSort(int[] arr){
        int len = arr.length;
        for(int i = len / 2 - 1; i >= 0; i--){
            buildHeap(arr, i, len);
        }


        for(int i = len - 1; i > 0 ; i--){
            swap(arr, 0, i);
            buildHeap(arr, 0, i);
        }
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void buildHeap(int[] arr, int index, int len){
        for(int i = index*2+1; i < len; i = i*2 +1){
            if(i+1 < len && arr[i+1] > arr[i]){
                i++;
            }
            if(arr[index] >= arr[i]){
                break;
            }else{
                swap(arr, index, i);
                index = i;
            }
        }
    }
}
