package qz2019.liuliyinyushuo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/30
 */

/**
 * 哈夫曼树编码：必须是前缀码，而且时最有前缀码
 *
 * 1.输出每个字符对应的哈夫曼编码
 * 2.输出编码后的长度
 *
 */
public class Huffman {

    static class Node{
        char ch;
        int num;
        Node left;
        Node right;

        public Node(char ch, int num){
            this.ch = ch;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.num - o2.num;
            }
        });
        int[] arr = new int[26];
        while(scanner.hasNext()){
            Arrays.fill(arr, 0);
            String s = scanner.next();
            for(int i = 0; i < s.length(); i ++){
                arr[s.charAt(i) - 'a']++;
            }
            for(int i = 0 ;  i< 26;  i++){
                if(arr[i] != 0)
                    queue.add(new Node((char)(i + 'a'), arr[i]));
            }

            //构造哈夫曼树，每次取出权值最小的数
            while(queue.size() > 1){
                Node first = queue.poll();
                Node second = queue.poll();
                Node node = new Node((char)27, first.num + second.num);
                node.left = first;
                node.right = second;
                queue.add(node);
            }
            Node root = queue.poll();

            //遍历哈夫曼树，解出字符串对应的哈夫曼编码的长度
            helper(root, 0);
            System.out.println(sum);
            sum = 0;
        }
    }

    static int res[] = new int[30];     //记录字符的编码
    static int sum = 0;
    public static void helper(Node root, int level){
        if(root != null){
            if(root.left == null && root.right == null){
                if(level == 0){         //以aaaa这种情况只有一种字符
                    res[level] = '0';
                    level++;
                }
                sum += level * root.num;
                System.out.println(root.ch + "=>" + new String(res, 0, level));
            }else{
                res[level] = '0'; //左分支为0
                helper(root.left, level+1);
                res[level] = '1'; //右分支为1
                helper(root.right, level+1);
            }
        }
    }
}
