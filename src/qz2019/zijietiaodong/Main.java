package qz2019.zijietiaodong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        HashSet<Integer> isVisited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            isVisited.add(v);
            for (int j = 0; j < n; j++) {
                if (i != j && !isVisited.contains(arr[j]) && yeushu(v, arr[j])) {
                    queue.offer(arr[j]);
                    isVisited.add(arr[j]);
                }
            }
            max = Math.max(max, isVisited.size());
            isVisited.clear();
        }
        System.out.println(max);
    }


    public static boolean yeushu(int m, int n) {
        for (int i = 2; i <= Math.sqrt(m) && i <= Math.sqrt(n); i++) {
            if (m % i == 0 && n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
