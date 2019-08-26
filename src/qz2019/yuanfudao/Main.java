package qz2019.yuanfudao;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i =0; i < n; i ++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ;  i < n ; i++){
            if(map.get(arr[i]) <= m){
                ans.add(arr[i]);
            }
        }

        for(Integer i : ans){
            System.out.print(i+" ");
        }
    }
}
