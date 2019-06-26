package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/26
 */
public class 堆棋子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       int[] x = new int[n];
       int[] y = new int[n];
       int[] ans = new int[n];
       for(int i = 0 ; i < n; i ++){
           x[i] = scanner.nextInt();
       }
       for(int i = 0 ; i < n ; i ++){
           y[i] = scanner.nextInt();
       }
        Arrays.fill(ans, Integer.MAX_VALUE);

       for(int i = 0; i < n ; i ++){
           for(int j = 0 ; j < n ; j ++){
               int temp = 0;
               int[] dist = new int[n];
               for(int k = 0; k < n ; k ++){
                   dist[k] = Math.abs(x[i] - x[k]) + Math.abs(y[j] - y[k]);
               }

               for(int k = 0; k < n ; k ++){
                   temp += dist[k];
                   ans[k] = Math.min(ans[k], temp);
               }
           }
       }

       for(int i = 0; i < n - 1; i ++)
           System.out.print(ans[i] + " ");
        System.out.print(ans[n - 1]);
    }
}
