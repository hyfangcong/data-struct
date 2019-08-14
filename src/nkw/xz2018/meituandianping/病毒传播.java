package nkw.xz2018.meituandianping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/10
 */
public class 病毒传播 {
    //感染病毒的点为true，没有感染的为false
    static boolean[] infected;
    static ArrayList<Integer>[] graph;
    static int n, m, k, t;

    public static void main(String[] args) {
        buildGraph();
        boolean flag = false;
        for(int i = 1; i <=n ; i++){
            if(bfs(i)){
                if(i == n){
                    System.out.print(i);
                }else{
                    System.out.print(i+" ");
                }
                flag = true;
            }
        }
        if(!flag){
            System.out.println("-1");
        }
    }

    public static void buildGraph(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList[n+1];
        infected = new boolean[n+1];
        for(int i = 1; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m ; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        k = scanner.nextInt();
        t = scanner.nextInt();
        for(int i = 0; i < k; i++){
            infected[scanner.nextInt()] = true;
        }
    }

    public static boolean bfs(int v){
        LinkedList<Integer> queue = new LinkedList();
        queue.offer(v);
        int[] cost = new int[n+1];
        cost[v] = 1;   //cost[i] > 0表示被感染了，cost[i]=0表示没有被感染
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(cost[cur] > t){
                break;
            }
            for(Integer item : graph[cur]){
                if(cost[item] == 0){
                    cost[item] = cost[cur] + 1;
                    queue.offer(item);
                }
            }
        }
        for(int i = 1; i <= n; i ++){
            if((!infected[i] && cost[i] > 0) || (infected[i] && cost[i] == 0)){
                return false;
            }
        }
        return true;
    }
}
