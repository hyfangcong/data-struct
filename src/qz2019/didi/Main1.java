package qz2019.didi;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/19
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] g = new int[n+1][n+1];
        for(int i = 0; i < m; i ++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g[u][v] = 1;
            g[v][u] = 1;
        }

        f(g);
    }

    public static void f(int[][] g){
        int ans  = 0;
        int n = g.length-1;
        boolean[] isVisited = new boolean[n+1];
        for(int i = 1; i <= n ; i ++){
            if(!isVisited[i]){
                int sum = 1;
                int last = -1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                isVisited[i] = true;
                while (!queue.isEmpty()){
                    int cur = queue.poll();
                    for(int j = 1; j <= n; j ++){
                        if(!isVisited[j] && g[cur][j] == 1){
                            queue.offer(j);
                            isVisited[j] = true;
                            sum++;
                            last = j;
                        }
                    }
                }
                if(last != -1 && g[i][last] == 1)
                    ans++;
            }
        }
        int tmp = n - ans;
        if(tmp % 2 == 0)
            System.out.println(tmp);
        else
            System.out.println(tmp - 1);
    }
}
