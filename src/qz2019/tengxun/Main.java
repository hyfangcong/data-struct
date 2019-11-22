package qz2019.tengxun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            a[i] = scanner.nextInt();
            map1.put(a[i], map1.getOrDefault(a[i], 0)+1);
        }
        for(int i = 0 ; i < n ; i++){
            b[i] = scanner.nextInt();
            map2.put(b[i], map2.getOrDefault(b[i], 0) + 1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < n ;j ++){
                if(map1.get(a[i]) % 2 == 0 || map2.get(b[i]) % 2 == 0)
                    continue;
                if(ans == Integer.MAX_VALUE){
                    ans = a[i] + b[j];
                }else{
                    int tmp = a[i] + b[j];
                    ans = ans ^ tmp;
                }
            }
        }
        System.out.println(ans);
    }
}
