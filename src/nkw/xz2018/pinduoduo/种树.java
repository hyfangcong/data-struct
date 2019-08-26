package nkw.xz2018.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/26
 */

/**
 *
 *
 */
public class 种树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = 0;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
            m+=arr[i];
        }
        List<Integer> b = new ArrayList<>();
        if(dfs(arr,b,m, -1)){
            for(int i = 0;  i< b.size(); i ++){
                System.out.print(b.get(i) + " ");
            }
        }else{
            System.out.println("-");
        }
    }

    public static boolean dfs(int[] arr, List<Integer> b, int m, int pre){
        if(m == 0)
            return true;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] * 2 > m+1){    //该品种的数量超过坑位的一半，会出现相邻的两个是同一个品种
                return false;
            }
            if(arr[i] > 0 && i+1 != pre){
                m--;
                b.add(i+1);
                arr[i]--;
                if(dfs(arr, b, m, i+1)) return true;
                m++;
                b.remove(b.size()-1);
                arr[i]++;
            }
        }
        return false;
    }
}
