package qz2019.weizhongyinhang;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/19
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] g = new int[n+1][n+1];
        for(int i = 1; i <= m; i ++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g[u][v] = 1;
            g[v][u] = 1;
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[n+1];
        list.add(start);
        isVisited[start] = true;
        dfs(g, isVisited, list, start, end);
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                System.out.print(i+" ");
            }
        }
    }
    static Set<Integer> set = new HashSet<>();
    private static void dfs(int[][] g, boolean[] isVisited, List<Integer> list, int cur, int end){
        if(set.contains(cur)){
            for(Integer e : list){
                set.add(e);
            }
            return;
        }
        if(cur == end){
            for(Integer e : list){
               set.add(e);
            }
            return;
        }

        for(int i = 1; i < g.length; i ++){
            if(!isVisited[i] && g[cur][i] == 1){
                isVisited[i] = true;
                list.add(i);
                dfs(g, isVisited, list, i, end);
                isVisited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
