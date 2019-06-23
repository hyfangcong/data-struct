package QIHU;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][4];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
            arr[i][3] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++){
            int temp = arr[i][3];
            if(arr[i][2] >= arr[i][0]){
                temp += arr[i][0];
                arr[i][0] = 0;
            }else{
                temp += arr[i][2];
                arr[i][0] = arr[i][0] - arr[i][2];
            }

            temp += arr[i][1] / 2;

            if(arr[i][1] % 2 == 1){
                arr[i][0] += 2;
            }
            temp += arr[i][0] / 4;
            System.out.println(temp);

        }

    }
}
