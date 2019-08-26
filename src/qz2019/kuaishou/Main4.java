package qz2019.kuaishou;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */

/**
 * 总数 - 红色连通域的个数
 *
 */
public class Main4 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // 0 : 无边   1：红  2：黑
        int[][] g = new int[n+1][n+1];
        for(int i = 1; i < n; i ++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g[u][v] = w+1;
            g[v][u] = w+1;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[n+1];
        for(int i = 1; i <= n; i ++){
            int sum = 1;
            if(!isVisited[i]){
                LinkedList<Integer> queue = new LinkedList<>();
                queue.offer(i);
                isVisited[i] = true;
                while (!queue.isEmpty()){
                    int v = queue.poll();
                    for(int j = 1; j <=n ;j ++){
                        if(!isVisited[j] && g[v][j] == 1){
                            queue.offer(j);
                            isVisited[j] = true;
                            sum++;
                        }
                    }
                }
                list.add(sum);
            }
        }

        int total = pow(n, k);
        for(Integer i : list){
            total = ((total+mod - pow(i,k))) % mod;
        }
        System.out.println(total);
    }

    public static int pow(int n, int k){
        int ans = 1;
        for(int i = 0; i < k ;  i++){
            ans = (ans*n) % mod;
        }
        return ans;
    }
}
