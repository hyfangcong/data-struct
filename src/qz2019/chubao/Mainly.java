package qz2019.chubao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: fangcong
 * @date: 2019/9/22
 */
public class Mainly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        Set<String> set = new HashSet<>();
        for(int i = 1; i < n-1;  i++){
            int j = i-1, k = i+1;
            while (j >=0 && k < n){
                int sum = arr[j] + arr[i] + arr[k];
                if(sum > 0){
                    j--;
                }else if(sum < 0){
                    k++;
                }else{
                    int[] tmp = new int[3];
                    tmp[0] = arr[i];
                    tmp[1] = arr[j];
                    tmp[2] = arr[k];
                    Arrays.sort(tmp);
                    String s = "" + tmp[0] + tmp[1] + tmp[2];
                    set.add(s);
                    j--;
                    k++;
                }
            }
        }
        System.out.println(set.size());
    }
}
