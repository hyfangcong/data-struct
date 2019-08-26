package nkw.xz2018.meituandianping;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/16
 */
public class 改考卷 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n ;i ++){
            int tmp = scanner.nextInt();
            sum += tmp;
            max = Math.max(tmp, max);
        }
        if(max > sum - max){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}
