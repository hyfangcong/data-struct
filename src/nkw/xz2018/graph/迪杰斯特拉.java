package nkw.xz2018.graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/11
 */
public class 迪杰斯特拉 {
    /**
     * 邻接矩阵表示法求解
     *
     * 求定点1到其他顶点的最短距离
     */
    public static void solution1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= n ;j++){
                graph[i][j] = scanner.nextInt();
            }
        }
        boolean[] isContain = new boolean[n+1];
        int[] dist = new int[n+1];
        isContain[1] = true;
        for(int i = 1; i <= n ;i ++){
            dist[i] = graph[1][i] == -1 ? Integer.MAX_VALUE : graph[1][i];
        }

        /**
         * 每次在当前的路径中找出距离定点1的最近的点k，并且k没有包含在集合s中。s：已经找到过的点
         *
         * 总共需要找n-1次
         */
        for(int time = 1; time < n; time++){
            int min = Integer.MAX_VALUE;
            int k = 0;
            for(int i = 1; i <= n; i++){
                if(!isContain[i] && dist[i] < min){
                    min = dist[i];
                    k = i;
                }
            }
            isContain[k] = true;
            for(int i = 2; i <= n ; i++){
                if(graph[k][i] != -1 && dist[i] > dist[k] + graph[k][i]){
                    dist[i] = dist[k] + graph[k][i];
                }
            }
            System.out.println(k);
            for(Integer p : dist){
                System.out.print(p+" ");
            }
            System.out.println();
            System.out.println("################################");
        }
        for(int i = 2; i <= n; i ++){
            System.out.print("1 -> " + i +": " + dist[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution1();
    }
}
