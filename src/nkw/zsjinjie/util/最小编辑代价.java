package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 最小编辑代价 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
        int[] arr = new int[3];
        for(int i = 0 ; i < 3; i ++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(minEditCost(s,p,0,0,arr,0));
    }

    public static int minEditCost(String s, String p, int ind1, int ind2, int[] arr, int cost){
        if(ind2 == p.length()){
            return cost;
        }
        if(ind1 == s.length()){
            return Integer.MAX_VALUE;
        }

        if(s.charAt(ind1) == p.charAt(ind2)){
            return minEditCost(s,p,ind1+1, ind2+1, arr,cost);
        }else {
            //插入
            int cost1 = minEditCost(s, p, ind1, ind2 + 1, arr, cost + arr[0]);
            //删除
            int cost2 = minEditCost(s, p, ind1 + 1, ind2, arr, cost + arr[1]);
            //替换
            int cost3 = minEditCost(s, p, ind1 + 1, ind2 + 1, arr, cost + arr[2]);

            return Math.min(Math.min(cost1, cost2), cost3);
        }
    }
}