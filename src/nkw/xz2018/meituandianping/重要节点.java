package nkw.xz2018.meituandianping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/12
 */
public class 重要节点 {
    //arrival[i][j] = true 表示可以从i到j，否则不能
     static boolean[][] arrival;
     static int[] sv;
     static int[] tv;
     static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        arrival = new boolean[n+1][n+1];
        sv = new int[n+1];
        tv = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i<= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
        }

        for(int i = 1; i <= n; i ++){
            bfs(i);
        }

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j++){
                if(arrival[i][j]){
                    sv[i]++;
                    tv[j]++;
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(tv[i] > sv[i])
                res++;
        }
        System.out.println(res);
    }

    public static void bfs(int v){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(v);
        arrival[v][v] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer u : graph[cur]){
                if(!arrival[v][u]){
                    arrival[v][u] = true;
                    queue.offer(u);
                }
            }
        }
    }
}
