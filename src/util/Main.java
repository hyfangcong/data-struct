package util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/9/6
 */
public class Main {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dfs(n, 0, false, 0);
        System.out.println(ans);
    }

    private static void dfs(int n, int index, boolean hasC, int numB){
        if(index == n){
            ans++;
            return;
        }

        //a
        dfs(n, index+1, hasC, 0);

        //b
        if(numB < 2){
            dfs(n, index+1, hasC, numB+1);
        }

        //c
        if(!hasC){
            dfs(n, index+1, true, 0);
        }
    }
}
