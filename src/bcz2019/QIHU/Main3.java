package QIHU;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i++){
            sum += Math.abs(arr[i] - (i + 1));
        }
        System.out.println(sum);
    }
}
