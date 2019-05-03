package tenxun2;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int num = 0;
        for(int i = n -1 ; i > 0 ; ){
            if(m > arr[i]){
                m -= arr[i];
                num++;
            }else{
                i--;
            }
        }

        if(m % arr[0] != 0){
            System.out.println(-1);
        }else{
            num += m / arr[0];
            System.out.println(num);

        }

    }
}
