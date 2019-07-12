package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 第二大的数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        int index = solution(arr, 0 , arr.length - 1);
        System.out.println(arr[index]);
    }

    public static int solution(int[] arr, int left, int right){
        int mid = helper(arr, left, right);
        if(mid == arr.length - 2){
            return mid;
        }else if(mid < arr.length - 2){
            return solution(arr, mid +1, right);
        }else
            return solution(arr, left, mid - 1);
    }

    public static int helper(int[] arr, int left, int right){
        int tmp = arr[left];
        while(left < right){
            while (left < right && arr[right] >= tmp)
                right--;
            swap(arr, left, right);
            while(left < right && arr[left] <= tmp){
                left++;
            }
            swap(arr, left, right);
        }
        arr[left] = tmp;
        return left;
    }

    public static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
