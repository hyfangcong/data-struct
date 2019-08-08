package nkw.zsjinjie.util;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/8
 */
public class 括号匹配 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String s = scanner.next();
            System.out.println(maxValidLen(s));
            System.out.println(maxValidLen2(s));
        }
    }

    /**
     * 判断字符串s是否是有效的括号匹配
     * @param s
     * @return
     */
    public static boolean process(String s){
        int sum = 0;
        for(int i = 0  ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                sum++;
            }else{
                sum--;
            }
            if(sum < 0)
                return false;
        }
        return sum==0;
    }

    /**
     * 给定的字符串s中，返回最长的有效括号子串
     *
     */
    public static int maxValidLen(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        boolean[][] p = new boolean[n][n];
        int max = 0;
        for(int i = n-1; i >= 0 ; i--){
            for(int j = i+1; j < n ;j ++){
                if(s.charAt(i)== '(' && s.charAt(j)==')' &&
                        (j-i<2 || p[i+1][j-1])){
                    dp[i] = Math.max(dp[i], dp[j+1] + j-i+1);
                    p[i][j] = true;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int maxValidLen2(String s){
        int n = s.length();
        int[] dp = new int[n];
        int pre = 0;
        int max = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == ')'){
                pre = i - dp[i-1] -1;
                if(pre >=0 && s.charAt(pre) == '('){
                    dp[i] = dp[i-1]+2+ (pre>0 ? dp[pre-1] : 0);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
