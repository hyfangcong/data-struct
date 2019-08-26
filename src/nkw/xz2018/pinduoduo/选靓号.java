package nkw.xz2018.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/26
 */
public class 选靓号 {
    static class Node{
        int x,y,z;
        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        int[] phone = new int[n];
        for(int i = 0 ; i < n ; i++){
            phone[i] = s.charAt(i) - '0';
        }
        int min = Integer.MAX_VALUE;
        int num = -1;
        for(int i = 0 ; i < 9; i ++){
            int[] tmp = new int[n];
            for(int j = 0; j < n; j ++){
                tmp[j] = Math.abs(phone[j] - i);
            }
            Arrays.sort(tmp);
            int sum = 0;
            for(int j = 0; j < k; j++){
                sum+=tmp[j];
            }
            if(sum < min){
                min = sum;
                num = i;
            }
        }
        Node[] ans = new Node[n];
        for(int i = 0; i < n; i ++){
            int x = Math.abs(phone[i] - num);
            int y = i;
            int z = phone[i] - num;
            ans[i] = new Node(x,y,z);
        }

        Arrays.sort(ans, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.x != o2.x){
                    return o1.x - o2.x;
                }
                if(o1.z != o2.z){
                    return o2.z - o1.z;
                }
                if(o1.z == o2.z && o1.z >= 0){
                    return o1.y - o2.y;
                }
                return o2.y - o1.y;
            }
        });
        for(int i = 0; i < k; i ++){
            int index = ans[i].y;
            phone[index] = num;
        }

        System.out.println(min);
        for(Integer i : phone){
            System.out.print(i);
        }
    }
}
