package data_struct.sort;

/**
 * @author: fangcong
 * @date: 2019/6/5
 */

/**
 * 堆排序
 */
public class Heap {
    public static void main(String[] args) {
        int[] arr = {15,4,10,9,7,3,8,90,3,7,11};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        Heap heap = new Heap();
        heap.heapSort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void heapSort(int[] arr){
        buildHeap(arr);
        for(int i = arr.length - 1; i > 0 ; i--){
            swap(arr, 0, i );
            adjustHeap(arr, 0, i );
        }

    }

    public void buildHeap(int[] arr){
        for(int i = arr.length / 2 - 1; i >= 0 ; i--){
            adjustHeap(arr, i, arr.length);
        }
    }

    private void adjustHeap(int[] arr, int index, int length) {
        for(int k = 2 * index + 1; k < length ; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            if(arr[index] < arr[k]){
                swap(arr, index, k);
                index = k;
            }else
                break;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



























}
