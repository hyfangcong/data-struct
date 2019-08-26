package nkw.xz2018.meituandianping;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/17
 */
public class 序列操作 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i ++){
            arr[i] = scanner.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = m-1; i >= 0 ; i--){
            if(!set.contains(arr[i])){
                System.out.println(arr[i]);
                set.add(arr[i]);
            }
        }

        for(int i = 1 ; i <= n ; i ++){
            if(!set.contains(i)){
                System.out.println(i);
            }
        }
    }
}
