package qz2019.tengxun;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class Main2 {
    static class Node{
        long a;
        long b;
        public Node(long a, long b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] arr = new Node[n];
        for(int i = 0; i < n; i ++){
            arr[i] = new Node(scanner.nextLong(), scanner.nextLong());
        }
        dfs(arr,0,n);
        System.out.println(min);

    }

    static long min = Long.MAX_VALUE;
    public static void dfs(Node[] arr, int index, int n){
        if(index == n){
            min = Math.min(min, helper(arr, n));
            return;
        }
        for(int i = index; i < n; i ++){
            Node tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
            dfs(arr, i+1, n);
            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

    public static long helper(Node[] arr, int n){
        long tmp = 0;
        for(int i = 0 ; i < arr.length; i ++){
            Node node = arr[i];
            tmp += node.a * (i) + node.b*(n - i - 1);
        }
        return tmp;
    }
}
