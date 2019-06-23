package bcz2019.jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] arr = new Node[n + 1];

        for(int i = 0 ; i < n - 1 ; i ++){
            int child = scanner.nextInt();
            int parent = scanner.nextInt();
            if(arr[parent] == null){
                arr[parent] = new Node(child, 0);
            }else{
                Node node = arr[parent];
                node.right = child;
                arr[parent] = node;
            }
        }
        Node node = arr[1];
        int left = fun(arr[node.left], arr);
        int right = fun(arr[node.right], arr);

        int max = left > right ? left : right;
        System.out.println(max);

    }

    static int fun(Node node, Node[] arr){
        if(node == null)
            return 0;

        int l , r ;
        l = fun(arr[node.left], arr) + 1;

        r = fun(arr[node.right], arr) + 1;

        return l + r;
    }

   static class Node{
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
