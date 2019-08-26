package util;

import static nkw.xz2018.jingdong.第二大的数.swap;

/**
 * @author: fangcong
 * @date: 2019/8/15
 *
 */
public class 快排 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        int[] arr3 = {2,2,2,2,3,3,3,3};
        int[] arr4 = {4,1,6,3,9,11,1};
        int[] arr5 = {3,2,1,4,5,1,2,3,7,9};
//        quickSort(arr1,0 ,arr1.length- 1);
//        quickSort(arr2, 0, arr2.length - 1);
//        quickSort(arr3, 0, arr3.length - 1);
//        quickSort(arr4, 0, arr4.length - 1);
        quickSort(arr5, 0, arr5.length-1);

//        for(int i = 0 ; i < arr1.length; i ++){
//            System.out.print(arr1[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0 ; i < arr2.length; i ++){
//            System.out.print(arr2[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0 ; i < arr3.length; i ++){
//            System.out.print(arr3[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0 ; i < arr4.length; i ++){
//            System.out.print(arr4[i] + " ");
//        }
        System.out.println();
        for(Integer i : arr5){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid);
            quickSort(arr, mid+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        while(left < right){
            while (left < right && arr[right] >= tmp)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < tmp)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        System.out.println(left);
        for(Integer i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        return left;
    }
}
