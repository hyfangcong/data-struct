package qz2019.pingduoduo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        int[] arr1 = new int[a.length];
        int[] arr2 = new int[b.length];
        for(int i = 0 ; i < a.length; i ++){
            arr1[i] = Integer.valueOf(a[i]);
        }
        for(int i = 0 ; i < b.length; i ++){
            arr2[i] = Integer.valueOf(b[i]);
        }

        int p = -1, q = -1;
        for(int i = 0 ; i < arr1.length - 1; i ++){
            if(arr1[i] - arr1[i+1] >= 0){
                q = i + 1;
                p = i;
                break;
            }
        }

        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 0 ; i < arr2.length; i ++){
            if(q == a.length - 1){
                if(arr2[i] > arr1[q - 1]){
                    max = Math.max(arr2[i], max);
                    flag = true;
                }
            }else{
                if(arr2[i] > arr1[q - 1] && arr2[i] < arr1[q + 1]){
                    max = Math.max(arr2[i], max);
                    flag = true;
                }
            }

            if(p == 0){
                if(arr2[i] < arr1[q]){
                    max = Math.max(arr2[i], max);
                }
            }else{
                if(arr2[i] > arr1[p - 1] && arr2[i] < arr1[q]){
                    max = Math.max(arr2[i], max);
                }
            }
        }
        if(max == Integer.MIN_VALUE){
            System.out.println("NO");
        }else{
            for(int i = 0 ;  i < arr1.length;  i++){
                if(i == q && !flag){
                    if(i == arr1.length - 1)
                        System.out.print(max);
                    else
                        System.out.print(max + " ");
                }
                else if(i == q && flag){
                    if(i == arr1.length - 1){
                        System.out.print(max);
                    }else{
                        System.out.print(max + " ");
                    }
                }else{
                    if(i == arr1.length - 1){
                        System.out.print(arr1[i]);
                    }else{
                        System.out.print(arr1[i] + " ");
                    }
                }
            }
        }
    }
}
