package qz2019.zijietiaodong;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n ; i ++){
            if(!isVisited[i]){
                queue.offer(i);
                isVisited[i] = true;
                while(!queue.isEmpty()){
                    int v = queue.poll();
                    for(int j = 0; j < n; j ++){
                        if(matrix[v][j] >= 3){
                            if(!isVisited[j]){
                                queue.offer(j);
                                isVisited[j] = true;
                            }
                        }
                    }
                }
                sum++;
            }
        }
        System.out.println(sum);
    }
}
