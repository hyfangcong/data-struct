package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 回文最小分割数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(plindromeMinCut(scanner.next()));
    }


    public static int plindromeMinCut(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        int[] dp = new int[len+1];
        dp[len] = 0;
        for(int i = len-1 ; i >= 0; i--){
            dp[i] = Integer.MAX_VALUE;
            for(int j = i ; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || p[i+1][j-1])){
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                    p[i][j] = true;
                }
            }
        }
        return dp[0];
    }

    public static int minCut(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int len = chas.length;
        int[] dp = new int[len + 1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chas[i] == chas[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }
}
