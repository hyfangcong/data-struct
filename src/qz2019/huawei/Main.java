package qz2019.huawei;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/4
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        while(n >= 0){
            if(n % 9 == 0){
                sum += n / 9;
                n = 0;
                break;
            }
            n -= 4;
            sum++;
        }
        sum = n == 0 ? sum : -1;
        System.out.println(sum);
    }
}
