package nkw.xz2018.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 弗洛伊德 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ;j ++){
                graph[i][j] = scanner.nextInt();
            }
        }
        floyd(graph);
    }
    public static void floyd(int[][] graph){
        int[][] dist = Arrays.copyOf(graph, graph.length);
        int n = dist.length;
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < n ; j++){
                    if(dist[i][k] != -1 && dist[k][j] != -1
                        && (dist[i][j] == -1 || dist[i][j] > dist[i][k] + dist[k][j])){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int[] arr : dist){
            for(Integer i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
