package qz2019.leihuo;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/15
 */
public class 工作安排 {
    static class Pair{
        int deadline;
        int cost;
        public Pair(int deadline, int cost){
            this.deadline = deadline;
            this.cost = cost;
        }
    }
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair[] arr = new Pair[n];
        for(int i = 0 ; i < n;  i++){
            arr[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }
        dfs(arr, 0, 0, 0);
        int ans = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(ans);
    }

    private static void dfs(Pair[] arr, int index, int curTime, int sum){

        if(index == arr.length){
            min = Math.min(min, sum);
            return;
        }
        for(int i = index; i < arr.length; i ++){
            int tmp = curTime+arr[i].cost - arr[i].deadline;
            int p = curTime+arr[i].cost;
            int q = tmp > 0 ? sum+tmp : sum;
            swap(arr, index, i);
            dfs(arr, index+1, p, q);
            swap(arr, index, i);
        }
    }

    private static void swap(Pair[]arr, int i, int j){
        Pair tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
