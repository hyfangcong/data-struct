package bytedance2;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0){
            int num = scanner.nextInt();
            int[] arr = new int[num];
            for(int i = 0 ; i < num ; i++){
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int i;
            int time = 0;
            for(i = arr.length - 1; i - 3 > 0; i -= 3){
                time += arr[i];
            }

            while(i >= 0){
                time += arr[i];
                i -= 2;
            }
            System.out.println(time);
        }

    }
}
