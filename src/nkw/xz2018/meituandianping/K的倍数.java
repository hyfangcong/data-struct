package nkw.xz2018.meituandianping;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/14
 */
public class K的倍数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        //key: sum[0-i] % k     value:最早出现的位置
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0,-1);
        for(int i = 0; i < n; i ++){
            sum += arr[i];
            sum %= k;
            if(memo.containsKey(sum)){
                maxLen = Math.max(maxLen, i - memo.get(sum));
            }else{
                memo.put(sum, i);
            }
        }
        System.out.println(maxLen);
    }
}
