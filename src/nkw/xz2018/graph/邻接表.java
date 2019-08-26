package nkw.xz2018.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 邻接表 {
    public static ArrayList<Pair>[] graph;

    static class Pair{
        int v;
        int w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void buildGraph(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m ; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }
    }
}
