package nkw.xz2018.duxiaoman;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/4
 */
public class 火车站台 {
    public static void main(String[] args) {
        int[] station = new int[100001];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(int j = y-1; j >= x; j--){
                station[j]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 1; i < station.length; i ++){
            if(station[i] > max){
                max = station[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}
