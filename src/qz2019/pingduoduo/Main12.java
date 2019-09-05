package qz2019.pingduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int pre = -1;
        int i,j;
        for(i = 1, j = 1; ; i++, j++){
            int tmp  = k - i*j;
            if(tmp <= 0){
                pre = k - (i-1) * (j-1);
                break;
            }
        }
        int ans = (m-i+1);
    }
}
