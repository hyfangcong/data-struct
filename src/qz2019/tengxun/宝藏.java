package qz2019.tengxun;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class 宝藏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int aji = 0, aou = 0, bji = 0, bou = 0;
        for(int i = 0 ; i< n; i ++){
            if(scanner.nextInt() % 2 == 0){
                aou++;
            }else{
                aji++;
            }
        }

        for(int i = 0; i < m; i++){
            if(scanner.nextInt() % 2 == 0){
                bou++;
            }else{
                bji++;
            }
        }

        System.out.println(Math.min(aji, bou) +  Math.min(aou, bji));
    }
}
