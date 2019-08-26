package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/17
 */
public class 硬币兑换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = {1,2,5,10,20,50,100};
        int p = 0, q = 0;
        for(int i = 0 ; i < arr.length; i ++){
            if(n >= arr[i]){
                n -= arr[i];
                p++;
                q++;
            }
        }
        q += n;
        System.out.println(p + " " + q);
    }
}
