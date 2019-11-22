package qz2019.tengxun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/20
 */
public class 两两配对 {
    static class Node{
        int delay;
        int size;
        public Node(int delay, int size){
            this.delay = delay;
            this.size = size;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] arr = new Node[n];
        for(int i = 0; i < n;  i++){
            int size = scanner.nextInt();
            int delay = scanner.nextInt();
            arr[i] = new Node(delay, size);
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.delay - o2.delay;
            }
        });
        int i = 0, j = n-1;
        int max = 0;
        while(i <= j){
            max = Math.max(max, arr[i].delay + arr[j].delay);
            if(arr[i].size < arr[j].size){
                arr[j].size -= arr[i].size;
                i++;
            }else if(arr[i].size > arr[j].size){
                arr[i].size -= arr[j].size;
                j--;
            }else{
                i++;
                j--;
            }
        }
        System.out.println(max);
    }
}
