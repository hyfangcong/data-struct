package qz2019.didi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/27
 */
public class 算式转移 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] ss = scanner.nextLine().split(" ");
        String[] opts = new String[n-1];
        for(int i = 1, j = 0; i < ss.length-1; i+=2, j++){
            opts[j] = ss[i];
        }
        int[] nums = new int[n];
        int size = 0;
        int preOpt = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < ss.length;){
            if(i % 2 == 0){
                list.add(Integer.valueOf(ss[i]));
                i++;
            }else{
                if(i == 1){
                    preOpt = f(ss[i]);
                    i++;
                }else{
                    int curOpt = f(ss[i]);
                    if(preOpt != curOpt){
                        if(list.size() > 2){
                            list.remove(list.size()-1);
                        }
                        Collections.sort(list);
                        for(int k = size; k < size+list.size(); k++){
                            nums[k] = list.get(k-size);
                        }
                        size+=list.size();
                        preOpt = curOpt;
                        i--;
                        list.clear();
                    }else{
                        i++;
                    }
                }
            }
        }
        Collections.sort(list);
        for(int k = size; k < size+list.size()-1; k++){
            nums[k] = list.get(k-size+1);
        }
        for(int i = 0; i < n-1; i ++){
            System.out.print(nums[i]+" " + opts[i]+" ");
        }
        System.out.print(nums[n-1]);
    }

    public static int f(String opt){
        switch (opt){
            case"+":
            case"-":
                return 0;
            case"*":
            case "/":
                return 1;
                default:return -1;
        }
    }
}
