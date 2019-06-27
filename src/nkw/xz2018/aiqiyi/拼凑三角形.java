package nkw.xz2018.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 拼凑三角形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        if(arr[2] < arr[0] + arr[1]){
            System.out.println(arr[0] + arr[1] + arr[2]);
        }else{
            System.out.println(2 * arr[0] + 2 * arr[1] - 1);
        }
    }
}
