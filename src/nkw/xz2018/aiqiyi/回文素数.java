package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 回文素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int sum = 0;
        for(int i = l; i <= r; i ++){
            if(isPrime(i) && isPalindrome(i))
                sum ++;
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int x){
        if(x == 0 || x == 1)
            return false;
        for(int i = 2; i <= x / 2; i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int x){
        int temp = 0, y = x;
        while(y != 0){
            temp = (temp * 10 + y % 10);
            y = y / 10;
        }
        return temp == x ? true : false;
    }


}
