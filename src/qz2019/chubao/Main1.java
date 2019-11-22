package qz2019.chubao;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/22
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(f(n,m,k));
    }

    private static int f(int n, int m, int k){
        int[] arr = new int[n+1];
        int tmpM = m;
        int cen = 0;
        while (tmpM > 0){
            arr[k]++;
            tmpM--;
            if(tmpM > 0){
                for(int i = k-1, j = k+1; i >=1+cen||j<=n-cen; i--,j++){
                    if(i >=1+cen && tmpM > 0){
                        arr[i]++;
                        tmpM--;
                    }
                    if(j<=n-cen && tmpM > 0){
                        arr[j] ++;
                        tmpM--;
                    }
                }
                cen++;
            }
        }
        return arr[k];
    }
}
