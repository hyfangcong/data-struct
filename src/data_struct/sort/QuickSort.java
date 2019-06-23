package data_struct.sort;

/**
 * @author: fangcong
 * @date: 2019/6/5
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {8,7,6,5,4,3,2,1};
        int[] arr3 = {2,2,2,2,3,3,3,3};
        int[] arr4 = {4,1,6,3,9,11,1};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr1,0 ,arr1.length- 1);
        sort.quickSort(arr2, 0, arr2.length - 1);
        sort.quickSort(arr3, 0, arr3.length - 1);
        sort.quickSort(arr4, 0, arr4.length - 1);

        for(int i = 0 ; i < arr1.length; i ++){
            System.out.print(arr1[i] + " ");
        }
        for(int i = 0 ; i < arr2.length; i ++){
            System.out.print(arr2[i] + " ");
        }
        for(int i = 0 ; i < arr3.length; i ++){
            System.out.print(arr3[i] + " ");
        }
        for(int i = 0 ; i < arr4.length; i ++){
            System.out.print(arr4[i] + " ");
        }

    }


    public void quickSort(int[] arr, int left, int right){
        if(left < right) {
            int mid = find(arr, left, right);
            quickSort(arr, left, mid);
            quickSort(arr, mid + 1, right);
        }
    }

    private int find(int[] arr, int left, int right) {
        int temp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= temp){
                right --;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] <= temp){
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int tmm = arr[left];
        arr[left] = arr[right];
        arr[right] = tmm;
    }
}
