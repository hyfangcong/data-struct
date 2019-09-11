package qz2019.xiaomi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/6
 */
public class Main2 {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Node root = build(input);
        inOrder(root);
        System.out.println(ans);
    }

    static String ans = "";
    private static Node build(String input) {
        if(input.length() == 0){
            return null;
        }
        if(input.length() == 1){
            return new Node(Integer.valueOf(input));
        }
        Node node = new Node(Integer.valueOf(input.charAt(0)));
        int sum = 0;
        int mid = 0;
//        if(input.length() <= 3){
//            String[] ss = input.split(",");
//        }
        if(input.length() == 2){
            if(input.charAt(0) == ','){
                node.left = build("");
                node.right = build(input.substring(1));
            }else{
                node.left = build(input.substring(0,1));
                node.right = build("");
            }
        }else if(input.length() == 3){
             node.left = build(input.substring(0,1));
             node.right = build(input.substring(2,3));
        }else{
            for(int i = 2; i < input.length();  i++){
                if(input.charAt(i) == '(')
                    sum++;
                else if(input.charAt(i) == ')')
                    sum--;
                if(sum == 0){
                    mid = i+1; //mid 处于逗号出
                }
            }
            node.left = build(input.substring(2,mid));
            node.right = build(input.substring(mid+1, input.length() - 1));
        }
        return node;
    }

    public static  void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            ans += root.value;
            inOrder(root.right);
        }
    }
}
