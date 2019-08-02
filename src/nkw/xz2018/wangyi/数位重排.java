package nkw.xz2018.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/18
 */
public class 数位重排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i ++){
            nums[i] = scanner.nextInt();
        }
        for(int i = 0 ; i < n ; i ++){
            int[] arr = new int[10];
            int num = nums[i];
            int x = num;
            while(x > 0){
                arr[x % 10] ++;
                x /= 10;
            }
            int j;
            for(j = 2; j <= 9; j ++){
                int tmp = num * j;
                int[] newArray = Arrays.copyOf(arr, arr.length);
                while(tmp > 0){
                    newArray[tmp % 10]--;
                    if(newArray[tmp % 10] < 0){
                        break;
                    }
                    tmp /= 10;
                }
                if(tmp == 0){
                    System.out.println("Possible");
                    break;
                }
            }
            if(j == 10)
                System.out.println("Impossible");
        }
    }
}
