package qz2019.shunfeng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/29
 */
public class Main3 {
    public static void main(String[] args){
        int n, m, k;
        final Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] tmp = new int[2];
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            tmp[0] = u;
            tmp[1] = v;
            arr[i] = tmp;
        }

        final HashMap<Integer, Boolean> person = new HashMap<>();
        final HashMap<Integer, Boolean> lang = new HashMap<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if(lang.size() >= m){
                for (int j = i; j < k; ++j){
                    person.put(j, true);
                }
                System.out.println(count + n - person.size());
                return;
            }
            if(person.containsKey(arr[i][0])){
                lang.put(arr[i][1],true);
                continue;
            }
            if(!lang.containsKey(arr[i][1])){
                count++;
                lang.put(arr[i][1], true);
            }
        }
        System.out.println(count);
    }
}