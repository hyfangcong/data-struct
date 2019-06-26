package nkw.xz2018.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/25
 */
public class 六一儿童节 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n; i ++){
            h[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] weight = new int[m];
        for(int i = 0; i < m; i ++){
            weight[i] = scanner.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(weight);
        int sum = 0;
        for(int i = 0, j = 0 ; i < h.length && j < weight.length;){
            if(weight[j] >= h[i]){
                sum++;
                j++;
                i++;
            }else{
                j++;
            }
        }
        System.out.println(sum);
    }
}
