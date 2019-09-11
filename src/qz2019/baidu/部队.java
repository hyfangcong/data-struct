package qz2019.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/10
 */
public class 部队 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(f(n, k));
    }

    static Map<Integer,Integer> map = new HashMap<>();
    public static int f(int n, int k){
        if(map.containsKey(n))
            return map.get(n);
        if(n <= k){
            return 1;
        }
        if((n+k) % 2 != 0)
            return 1;

        int x = (n+k) / 2;
        int y = x - k;
        int num =  f(x, k) + f(y, k);
        map.put(n, num);
        return num;
    }
}
