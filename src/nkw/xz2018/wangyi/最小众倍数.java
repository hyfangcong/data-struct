package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/15
 */
public class 最小众倍数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0 ; i < 5; i ++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 1; ; i ++){
            for(int j = 0 ; j < 5; j ++){
                hashMap.put(i * arr[j], hashMap.getOrDefault(i * arr[j], 0) + 1);
                if(hashMap.get(i * arr[j]) >= 3){
                    System.out.println(i * arr[j]);
                    return;
                }
            }
        }
    }
}
