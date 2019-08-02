package nkw.zsjinjie.topk;

/**
 * @author: fangcong
 * @date: 2019/8/1
 */

import static nkw.xz2018.jingdong.第二大的数.swap;

/**
 * 时间复杂度为O（nlogk）
 *
 */
public class Heap {

    public static void main(String[] args) {
        int[] arr = {2,4,5,1,7,4,8,0};
        int[] arr2 = {4,2,4,4,4,5};
        buildHeap(arr, 1);
    }


    public static void buildHeap(int[] arr, int k){
        //初始化一个大小为K的小顶堆
        for(int i = k/2-1; i >= 0; i --){
            adjustHeap(arr, i, k);
        }

        //遍历剩余的k ... n-1的元素
        for(int i = k; i < arr.length; i ++){
           if(arr[i] > arr[0]){
               swap(arr, 0, i);
               adjustHeap(arr, 0, k);
           }
        }
        System.out.println(arr[0]);
    }


    public static void adjustHeap(int[] arr, int index, int len){
        for(int i = index*2+1; i < len; i = i*2+1){
            if(i + 1 < len && arr[i+1] < arr[i]){
                i++;
            }
            if(arr[index] > arr[i]){
                swap(arr, index, i);
                index = i;
            }else
                break;
        }
    }
}
