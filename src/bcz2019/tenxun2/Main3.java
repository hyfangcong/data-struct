package bcz2019.tenxun2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] power = new long[n];
        int[] coin = new int[n];

        for(int i = 0 ; i < n; i ++){
            power[i] = scanner.nextLong();
        }

        for(int i = 0 ; i < n; i++){
            coin[i] = scanner.nextInt();
        }

        int sum = 0;
        long cur = 0;
        for(int i = 0 ; i < n; i ++){
            if(cur < power[i]){
                cur += power[i];
                sum += coin[i];
            }
        }

        System.out.println(sum);
    }
}
