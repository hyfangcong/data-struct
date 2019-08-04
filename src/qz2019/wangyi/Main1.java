package qz2019.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/3
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] query = new int[m];
        for(int i = 0 ; i < m ;i ++){
            query[i] = scanner.nextInt();
        }
        int[] sort = Arrays.copyOf(arr,n);
        Arrays.sort(sort);
        for(int i = 0 ; i < m; i ++){
            int index = Arrays.binarySearch(sort,arr[query[i]-1]);
            while(index + 1 < n && sort[index] == sort[index+1]){
                index++;
            }
            double res = (double)(index) / n *100;
            System.out.printf("%f",res);
            System.out.println();
        }
    }
}
