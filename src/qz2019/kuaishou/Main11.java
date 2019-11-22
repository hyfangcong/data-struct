package qz2019.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: fangcong
 * @date: 2019/9/16
 */
public class Main11 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        Condition full = lock.newCondition();
        try {
            full.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        full.signal();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0 ; i < n; i ++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        int m = sum / 2;
        int[] dp = new int[m+1];
        for(int i = 0; i < n; i ++){
            for(int j = m;  j >= 0; j --){
                if(j >= arr[i]){
                    dp[j] = Math.max(dp[j], dp[j-arr[i]]+arr[i]);
                }
            }
        }
        System.out.println(sum - 2*dp[m]);
    }
}
