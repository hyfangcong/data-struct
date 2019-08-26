package util;

import static nkw.xz2018.jingdong.第二大的数.swap;

/**
 * @author: fangcong
 * @date: 2019/8/15
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        int[] arr3 = {2,2,2,2,3,3,3,3};
        int[] arr4 = {4,1,6,3,9,11,1};
        int[] arr5 = {3,2,1,4,5,1,2,3,7,9};
        buboolSort(arr1);
        buboolSort(arr2);
        buboolSort(arr3);
        buboolSort(arr4);
        buboolSort(arr5);
    }

    public static void buboolSort(int[] arr){
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            for(int k = 0; k <= i; k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
        for(Integer i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
