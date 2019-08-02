import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TTTT {
    static class Node{
        int pos;
        int h;
        public Node(int pos, int h){
            this.pos=pos;
            this.h=h;
        }
    }
    public static void main(String[] args) {
       Node[] arr = new Node[10];
       for(int i = 0; i < 10; i ++){
           arr[i] = new Node(i,-1);
       }
       Arrays.sort(arr, new Comparator<Node>() {
           @Override
           public int compare(Node o1, Node o2) {
               return o2.pos - o1.pos;
           }
       });

       for(Node node : arr){
           System.out.print(node.pos+" ");
       }
    }
}
