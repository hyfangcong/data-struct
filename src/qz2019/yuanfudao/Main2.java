package qz2019.yuanfudao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/24
 */
public class Main2 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T  = scanner.nextInt();
        for(int t = 0; t < T; t++){
            sum = 0;
            int n = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int p  = scanner.nextInt();
                if(p!=0){
                    list.add(p);
                }
            }
            Collections.sort(list);
            helper(list);
            System.out.println(sum);
        }
    }

    public static void helper(ArrayList<Integer>input){
        if(input.size() < 3){
            return;
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        int n = input.size();
        int i = n-1;
            int p = input.get(i-2);
            sum+=p;
            if(input.get(i) - p != 0){
                tmp.add(input.get(i) - p);
            }
            if(input.get(i-1) - p != 0){
                tmp.add(input.get(i-1) - p);
            }
        Collections.sort(tmp);
        helper(tmp);
    }
}
