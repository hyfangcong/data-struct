package qz2019.tengxun;

import java.util.*;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class 排队 {
    static class Node{
        int a;
        int b;
        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] arr = new Node[n];
        for(int i = 0; i < n; i ++){
            arr[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.a != o2.a){
                    return o2.a - o1.a;
                }

                return o1.b - o2.b;
            }
        });
        long ans = Long.MAX_VALUE;
        long tmp = 0;
        for(int i = 0 ; i < arr.length; i ++){
            Node node = arr[i];
            tmp += node.a * (i) + node.b*(n - i - 1);
        }
        ans = Math.min(ans, tmp);
        tmp = 0;

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.b != o2.b){
                    return o1.b - o2.b;
                }

                return o2.a - o1.a;
            }
        });
        for(int i = 0 ; i < arr.length; i ++){
            Node node = arr[i];
            tmp += node.a * (i) + node.b*(n - i - 1);
        }
        ans = Math.min(ans, tmp);
        System.out.println(ans);
    }
}
