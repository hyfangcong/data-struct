package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 字符串的交错组成 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(stringCross(scanner.next(), scanner.next(), scanner.next()));
        }
    }

    public static boolean stringCross(String str1, String str2, String aim){
        int len1 = str1.length();
        int len2 = str2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i = 1; i <= len1; i++){
            if(str1.charAt(i-1) != aim.charAt(i-1)){
                break;
            }
            dp[i][0] = true;
        }

        for(int i = 1; i <= len2; i++){
            if(str2.charAt(i-1) != aim.charAt(i-1)){
                break;
            }
            dp[0][i] = true;
        }

        for(int i = 1; i <= len1; i ++){
            for(int j = 1; j <= len2;j++){
                if((str1.charAt(i-1) == aim.charAt(i+j-1) && dp[i-1][j]) ||
                        (str2.charAt(j-1) == aim.charAt(i+j-1) && dp[i][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        return dp[len1][len2];
    }
}
