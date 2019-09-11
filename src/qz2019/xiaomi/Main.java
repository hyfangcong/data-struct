package qz2019.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] price = new int[n];
        for(int i = 0 ; i < n;  i++){
            price[i] = scanner.nextInt();
        }
        int total = scanner.nextInt();
        Arrays.sort(price);
        int maxIndex = -1;
        for(int i = n-1; i >= 0;  i--){
            if(price[i] <= total){
                maxIndex = i;
                break;
            }
        }
        if(maxIndex == -1){
            System.out.println(-1);
            return;
        }

        System.out.println(getCount(price, total, maxIndex+1));
    }
    private  static int getCount(int[] price , int total, int n){
        if(n == 0)
            return -1;

        int count = total / price[n-1];
        int left = total % price[n-1];
        if(left == 0)
            return count;
        for(int i = count; i >= 0;  i--){
            int tmp = getCount(price, total-i*price[n-1], n-1);
            if(tmp != -1)
                return i+tmp;
        }
        return -1;
    }

}
