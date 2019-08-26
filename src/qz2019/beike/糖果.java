package qz2019.beike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/23
 */
public class 糖果 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
            list.add(arr[i]);
        }
        Collections.sort(list);
        helper(list, true);
        System.out.println(ans);
    }

    public static void helper(ArrayList<Integer> input, boolean flag){
        if(!flag){
            ans = input.size();
            return;
        }
        boolean ff = false;
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0;  i < input.size();){
            if(i+1 < input.size() && input.get(i).equals(input.get(i+1))){
                tmp.add(input.get(i)*2);
                i+=2;
                ff = true;
            }else{
                tmp.add(input.get(i));
                i++;
            }
        }
        Collections.sort(tmp);
        helper(tmp, ff);
    }
}
