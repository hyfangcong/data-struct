package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 吃鱼 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n <= m){
            System.out.println(2);
        }else{
            if(2*n % m == 0){
                System.out.println(2*n / m);
            }else{
                System.out.println(2*n / m + 1);
            }
        }
    }
}
