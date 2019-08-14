package nkw.cxymszn;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class 最长的可整合子数组的长度 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int len = 1;
        for(int i = 0; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            if(len >= n - i + 1){
                break;
            }
            int max = arr[i], min = arr[i];
            set.add(arr[i]);
            for(int j = i + 1; j < n; j++){
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                if(arr[j] > max){
                    max = arr[j];
                }

                if(arr[j] < min){
                    min = arr[j];
                }
                if(max - min == j - i ){
                    len = Math.max(len, max-min+1);
                }
            }
            set.clear();
        }
        System.out.println(len);
    }
}
