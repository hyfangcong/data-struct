package qz2019.tengxun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/20
 */
public class 最小非零元素 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;  i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        int i = 0;
        while (k > 0){
            if(i == n){
                System.out.println(0);
                k--;
            }else{
                if(arr[i] > sum){
                    int tmp = arr[i] - sum;
                    System.out.println(tmp);
                    sum += tmp;
                    k--;
                }
                i++;
            }
        }
    }
}
