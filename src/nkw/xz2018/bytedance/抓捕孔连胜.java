package nkw.xz2018.bytedance;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/5
 */
public class 抓捕孔连胜 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(helper2(arr, d));
    }


    //队列中维护一个窗口，窗口中的距离最大为d
    private static long helper2(int[] arr, int d) {
        long ans = 0;
        int mod = 99997867;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[i] - queue.getFirst() > d) {
                queue.poll();
                ans = (ans + calculate(queue.size())) % mod;
            }
            queue.offer(arr[i]);
        }
        while (!queue.isEmpty()){
            queue.poll();
            ans = (ans + calculate(queue.size())) % mod;
        }
        return ans;
    }

    private static long calculate(long sum) {
        if (sum < 2) {
            return 0;
        }
        return ((sum) * (sum - 1) / 2) % 99997867;
    }
}
