package qz2019.wangyi.time81;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/11
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i ++){
             char[] arr = scanner.next().toCharArray();
             int sum = 0;
             int left = 0;
             int right = 1;
             int max = 0;
             for(;right < arr.length; right++){
                 if(arr[right] != 'N'){
                     if(sum == 2){
                         max = Math.max(max, right-left);
                         while(arr[left] == 'N'){
                             left++;
                         }
                         left++;
                     }else {
                         sum++;
                     }
                 }
             }
             max = Math.max(max, right - left);
            System.out.println(max);
        }
    }
}
