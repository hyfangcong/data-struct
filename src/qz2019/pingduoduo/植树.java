package qz2019.pingduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/25
 */
public class 植树 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] hasVisited = new boolean[n+1];
        int sum = 0;
        for(int i = 0; i < m ; i++){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            sum += f(left, right, sum,hasVisited);
        }
    }

    private static  int f(int left, int right, int sum , boolean[] hasVisited){
        int count = 0;
        for(int i = left;  i<= right;  i++){
            if(!hasVisited[i]){
                count++;
                hasVisited[i] = true;
            }
        }
        System.out.println(sum+count);
        return count;
    }
}
