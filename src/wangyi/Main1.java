package wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n;  i++){
            arr[i] = scanner.next();
        }

        Set<String> set = new HashSet<>();
        for(int i =0 ; i < n ; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }
        }

        System.out.println(set.size());
    }
}
