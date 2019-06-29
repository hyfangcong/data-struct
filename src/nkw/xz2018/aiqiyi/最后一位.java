package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/28
 */

/**
 * 二分法
 */
public class 最后一位 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long l = 0;
        long r = num;
        while(l <= r){
            long mid = l + (r - l) / 2;
            long temp = process(mid);
            if( temp == num){
                System.out.println(mid);
                return;
            }else if(temp > num){
                r = mid - 1;
            }else
                l = mid + 1;
        }
        System.out.println(-1);
    }

    private static long process(long mid) {
        long res = 0;
        do{
            res += mid;
            mid /= 10;
        }while(mid > 0);
        return res;
    }
}
