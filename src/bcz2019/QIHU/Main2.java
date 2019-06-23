package QIHU;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }

        int [][] count = new int[m][2];
        for(int i = 0 ; i < m; i++){
            count[i][0] = scanner.nextInt();
            count[i][1] = scanner.nextInt();
        }

        for(int i = 0; i < m; i ++){
            sort(arr,count[i][0], count[i][1]);
        }

        for(int i = 0; i < n ; i++){
            if(i != n -1){
                System.out.print(arr[i] + " ");
            }else{
                System.out.print(arr[i]);
            }
        }
    }

    public static void sort(int[] arr, int flag, int e){


            int [] temp  = new int[e];
            for(int i = 0; i <e ; i++){
                temp[i] = arr[i];
            }

            Arrays.sort(temp);

            if(flag == 1){
                int n = e - 1;
                for(int i = 0 ; i <e ; i ++){
                    arr[i] = temp[n];
                    n--;
                }
            }else{
                for(int i = 0; i < e; i++){
                    arr[i] = temp[i];
                }
            }
    }
}
