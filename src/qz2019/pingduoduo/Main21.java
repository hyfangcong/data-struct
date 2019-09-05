package qz2019.pingduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/1
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] ss = line.split(",|;");
        int n = Integer.valueOf(ss[ss.length-1]);
        Integer[] arr = new Integer[ss.length-1];
        for(int i = 0 ;  i< arr.length ; i++){
            arr[i] = Integer.valueOf(ss[i]);
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 % 2 == 0 && o2 % 2 != 0){
                    return 1;
                }
                if(o1 % 2 != 0 && o2 % 2 == 0){
                    return -1;
                }

                if(o1 % 2 == 0 && o2 % 2 == 0){
                    return o1 - o2;
                }
                if(o1 % 2 != 0 && o2 % 2 != 0){
                    return o1-o2;
                }
                return 0;
            }
        });
        for(int i = arr.length - 1; i >= arr.length - n; i--){
            if(i == arr.length-n){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }
}
