package qz2019.pingduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/28
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cost = new int[n + 1];
        for(int i = 1 ; i <= n ; i ++)
            cost[i] = scanner.nextInt();

        int[][] depend = new int[m][2];
        for(int i = 0; i < m ; i ++){
            depend[i][0] = scanner.nextInt();
            depend[i][1] = scanner.nextInt();
        }


    }
}
