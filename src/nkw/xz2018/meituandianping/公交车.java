package nkw.xz2018.meituandianping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/10
 */
public class 公交车 {
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList[n+m+1];
        for(int i = 1 ; i <= m ; i ++){
            int t = scanner.nextInt();
            graph[i+n] = new ArrayList<>();
            for(int j = 0 ; j < t;  j++){
                int station = scanner.nextInt();
                if(graph[station] == null){
                    graph[station] = new ArrayList<>();
                }
                graph[station].add(i+n);
                graph[i+n].add(station);
            }
        }
        int res = bfs(1, m, n);
        System.out.println(res == 0 ? -1 : res / 2);
    }

    public static int bfs(int index, int m, int n){
        int[] cost = new int[n+m+1];
        cost[index] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(index);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer e : graph[cur]){
                if(cost[e] == 0){
                    cost[e] = cost[cur] + 1;
                    queue.offer(e);
                }
            }
        }
        return cost[n];
    }
}
