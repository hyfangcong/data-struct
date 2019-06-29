package nkw.xz2018.bytedance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/29
 */
public class 推箱子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[][] chas = new char[m][n];
        int startX = 0, startY = 0, boxX = 0, boxY = 0;
        for(int i = 0; i < m; i ++){
            String s = scanner.next();
            for(int j = 0 ; j < n ; j ++){
                chas[i][j] = s.charAt(j);
                if(chas[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }

                if(chas[i][j] == '0'){
                    boxX = i;
                    boxY = j;
                }
            }
        }
        System.out.println(bfsMinStep(chas, startX, startY, boxX, boxY));
    }

    static class Node{
        int px;
        int py;
        int bx;
        int by;
        int step;
        public Node(int px, int py, int bx, int by, int step){
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
            this.step = step;
        }
    }

    private static int bfsMinStep(char[][] chas, int startX, int startY, int boxX, int boxY) {
        int m = chas.length;
        int n = chas[0].length;
        boolean[][][][] isVisited = new boolean[m][n][m][n];
        int[][] dir = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, boxX, boxY, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int newBx = node.bx;
            int newBy = node.by;
            for(int i = 0 ; i < 4; i ++){
                //在箱子上面或者下面
                if(node.py == node.by){
                    newBx = node.px + dir[i][0] == node.bx ? node.bx + dir[i][0] : node.bx;
                }

                //在箱子左边或者右边
                if(node.px == node.bx){
                    newBy = node.py + dir[i][1] == node.by ? node.by + dir[i][1] : node.by;
                }

                Node next = new Node(node.px + dir[i][0], node.py + dir[i][1], newBx, newBy, node.step);
                if(next.px<0 || next.px >= m || next.py<0 || next.py>=n || chas[next.px][next.py] == '#'
                || next.bx<0 || next.bx>= m || next.by<0 || next.by >=n || chas[next.bx][next.by] == '#')
                    continue;
               if(!isVisited[next.px][next.py][next.bx][next.by]){
                   isVisited[next.px][next.py][next.bx][next.by] = true;
                   next.step = next.step + 1;
                   if(chas[next.bx][next.by] == 'E')
                       return next.step;
                   queue.add(next);
               }
            }
        }
        return -1;
    }
}
