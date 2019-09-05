package qz2019.shunfeng;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/29
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n+1][m+1];
        for(int i = 0 ; i < k; i ++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            matrix[u][v] = 1;
        }
        int ans = 0;
        boolean[] isVisited = new boolean[n+1];
        for(int i = 1; i <= n ; i++){
            if(!isVisited[i]){
                LinkedList<Integer> queue = new LinkedList<>();
                queue.offer(i);
                isVisited[i] = true;
                while (!queue.isEmpty()){
                    int u = queue.poll();
                    for(int v = 1; v <= m; v++){
                        if(matrix[u][v] == 1){
                            for(int t = 1; t <= n; t++){
                                if(!isVisited[t] && matrix[t][v] == 1){
                                    queue.offer(t);
                                    isVisited[t] = true;
                                }
                            }
                        }
                    }
                }
                ans++;
            }
        }
        System.out.println(--ans);
    }
}
