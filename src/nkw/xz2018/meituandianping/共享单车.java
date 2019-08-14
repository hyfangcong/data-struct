package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/11
 */
public class 共享单车 {
    static int[][] matrix;
    static int[] dist;
    static boolean[] bike;
    static boolean[] isContain;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        matrix = new int[n+1][n+1];
        dist = new int[n+1];
        bike = new boolean[n+1];
        isContain = new boolean[n+1];
        int vs = 1;
        for(int i = 0; i< n; i ++){
            for(int j = 0; j<n; j++){
                matrix[i+1][j+1] = scanner.nextInt();
            }
        }
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            bike[i+1] = true;
        }

        dist[vs] = 0;
        isContain[vs] = true;
        for(int i = 1; i <= n; i++){
            if(!isContain[i]){
                if(bike[i]){
                    dist[i] = matrix[1][i] == 0 ? Integer.MAX_VALUE : matrix[1][i] / 2;
                }else{
                    dist[i] = matrix[1][i] == 0 ? Integer.MAX_VALUE : matrix[1][i];
                }
            }
        }
        int k = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 2; i <= n; i++){  //将剩下的n-1个节点纳入到集合中
            for(int j = 1; j <= n; j ++){
                if(!isContain[j]){
                    if(dist[j] < min){   //每次取出从vs到{没有纳入集合节点}距离最短的那个节点
                        k = j;
                        min = dist[j];
                    }
                }
            }

            for(int j = 1; j <= n; j++){
            }
        }
        for(int i = 2; i <= n; i++){
            if(dist[i] < min){
                k = i;
                min = dist[i];
            }
        }
        isContain[k] = true;
        for(int i = 1; i <= n ;i++){
            if(!isContain[i]){

            }
        }
    }
}
