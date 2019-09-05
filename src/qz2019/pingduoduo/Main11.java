package qz2019.pingduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;  i<= n ;  i++){
            for(int j = 1;  j <= m; j ++){
                list.add(i * j);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int ans = 0;
        if(k <= list.size()){
            ans = list.get(k-1);
        }
        System.out.println(ans);
    }
}
