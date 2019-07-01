package nkw.xz2018.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/30
 */
public class 点集 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] arr = new Node[n];
        for(int i = 0; i < n ; i++){
            arr[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(arr, (o1,o2) -> {
            return o1.x - o2.x;
        });

        ArrayList<Node> res = new ArrayList<>();
        res.add(arr[n - 1]);
        int maxY = arr[n - 1].y;
        for(int i = n-2; i >= 0; i--){
            if(arr[i].y > maxY){
                res.add(arr[i]);
                maxY = arr[i].y;
            }
        }
        for(int i = res.size() - 1; i >= 0 ; i--){
            System.out.printf("%d %d\n",res.get(i).x ,  res.get(i).y);
        }
    }
}
