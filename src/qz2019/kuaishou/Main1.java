package qz2019.kuaishou;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for(int i = 0; i < m; i ++){
            String pre = scanner.next();
            String cur = scanner.next();
            helper(pre, cur);
        }
    }

    public static void helper(String pre, String cur){
        if(pre == "" && cur == ""){
            System.out.println("false");
            return;
        }
        if(pre == ""){
            System.out.println("true");
            return;
        }
        if(cur == ""){
            System.out.println("false");
            return;
        }
        String[] pres = pre.split("\\.");
        String[] curs = cur.split("\\.");
        int n = pres.length;
        int m = curs.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0; i < n; i ++){
            arr1[i] = Integer.valueOf(pres[i]);
        }

        for(int i = 0; i < m; i ++){
            arr2[i] = Integer.valueOf(curs[i]);
        }
        int i = 0, j = 0;
        while(i < n && j < m){
            if(arr1[i] > arr2[j]){
                System.out.println("false");
                return;
            }
            if(arr1[i] < arr2[j]){
                System.out.println("true");
                return;
            }
            i++;
            j++;
        }
        if(i < n){
            System.out.println("false");
            return;
        }else if( j < m){
            while(j < m){
                if(arr2[j] > 0){
                    System.out.println("true");
                    return;
                }
                j++;
            }
            System.out.println("false");
        }else{
            System.out.println("false");
        }
    }
}
