package qz2019.tengxun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/17
 */
public class 照亮河道 {
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        Pair[] arr = new Pair[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x - o2.x;
            }
        });
        int i;
        for(i = 0 ; i < n; i ++){
            if(arr[i].y >= l){
                break;
            }
        }
        System.out.println(i+1);
    }
}
