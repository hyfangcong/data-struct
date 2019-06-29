package nkw.xz2018.bytedance;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/29
 */
public class 房间分配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int end = scanner.nextInt() - 1;
        long[] room = new long[n];
        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextInt();
        }

        int start;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, room[i]);
        }

        for(int i = end; ; i = (i - 1 + n) % n){
           if(room[i] == min){
               start = i;
               break;
           }
        }

        for (int i = 0; i < n; i++) {
           room[i] -= min;
        }
        int remain = 0;
        for (int i = end; i != start; i = (i - 1 + n) % n) {
            room[i]--;
            remain++;
        }
        room[start] = remain + n * min;
        for(int i = 0; i < n; i ++){
            System.out.print(room[i] + " ");
        }
    }
}
