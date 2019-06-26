package nkw.xz2018.pinduoduo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/25
 */
public class 迷宫寻路 {
    static class Node{
        int x;
        int y;
        int step;
        int key;
        public Node(int x, int y, int step, int key){
            this.x = x;
            this.y = y;
            this.step = step;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] matrix = new char[m][n];
        for(int i = 0; i < m ; i ++){
            matrix[i] = scanner.nextLine().toCharArray();
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == '2'){
                    System.out.println(bfs(matrix, m, n, i, j));
                    return;
                }
            }
        }
    }

    public static int bfs(char[][] matrix, int m, int n, int x, int y){
        boolean[][][] isVisited = new boolean[101][101][1025];
        int [][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i = 0; i < direction.length; i ++){
                int nx = node.x + direction[i][0];
                int ny = node.y + direction[i][1];
                int key = node.key;
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == '0')
                    continue;
                else if(matrix[nx][ny] == '3')
                    return node.step + 1;
                else if(matrix[nx][ny] <= 'z' && matrix[nx][ny] >= 'a')
                    key = key | (1 << (matrix[nx][ny] - 'a'));
                else if(matrix[nx][ny] <= 'Z' && matrix[nx][ny] >= 'A' && (key & (1 << (matrix[nx][ny] - 'A'))) == 0)
                    continue;
                if(!isVisited[nx][ny][key]){
                    isVisited[nx][ny][key] = true;
                    queue.add(new Node(nx, ny, node.step + 1, key));
                }
            }
        }
        return -1;
    }
}
