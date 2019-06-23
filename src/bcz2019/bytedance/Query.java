package bcz2019.bytedance;

import java.util.*;

public class Query {
    private static class Node{
        public int left;
        public int right;
        public int element;
        public Node(int left, int right, int element){
            this.left = left;
            this.right = right;
            this.element = element;
        }

        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("Node: [left:" + left + " right:" + right + " element:" + element + "]");
            return builder.toString();
        }
    }

     private static Integer[] data;
     private static Node[] querys;
     private static Map<Integer,List<Integer>> map;

     private static void init(){
         Scanner scanner = new Scanner(System.in);
         data = new Integer[scanner.nextInt()];
         for(int i = 0; i < data.length; i++){
             data[i] = scanner.nextInt();
         }

         map = new HashMap<>();
         for(int i = 0; i < data.length; i++){
             if(!map.containsKey(data[i])){
                 ArrayList<Integer> list = new ArrayList<>();
                 list.add(i + 1);
                 map.put(data[i], list);
             }else{
                 List list = map.get(data[i]);
                 list.add(i + 1);
                 map.put(data[i],list);
             }
         }
         querys = new Node[scanner.nextInt()];
         for(int i = 0; i < querys.length; i++){
             Node node = new Node(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
             querys[i] = node;
         }
     }

     private static void process1(){
         for(Node node : querys){
             int sum = 0;
             for(int i = node.left - 1; i < node.right; i++){
                 if(data[i] == node.element)
                     sum++;
             }
             System.out.println(sum);
         }
     }

     //与查询区间长度无关
     private static void process2(){
         for(Node node : querys){
             int sum = 0;
             List<Integer> list = map.get(node.element);
             if(list != null){
                 for(Integer index : list){
                     if(node.left <= index && index <= node.right)
                         sum++;
                 }
             }
             System.out.println(sum);
         }
     }

    public static void main(String[] args) {
         init();

        for(int e : data){
            System.out.print(e +"  ");
        }

        System.out.println();

        for(Node node : querys){
            System.out.println(node);
        }

        process2();
    }
}
