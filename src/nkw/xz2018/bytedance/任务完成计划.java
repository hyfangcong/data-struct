package nkw.xz2018.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/30
 */
public class 实现的时间点 {
    static class Node{
        int number;
        int time;
        int priority;
        int need;
        public Node(int number, int time, int priority, int need){
            this.number = number;
            this.time = time;
            this.priority = time;
            this.need = need;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        for(int i = 0 ; i < q ; i ++){

        }
    }
}
