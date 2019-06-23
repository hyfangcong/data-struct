package company.jingdong.j2019;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/23
 */
public class 实现字通配符 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String s = sc.nextLine();
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        boolean flag = true;

        for(int i = 0; i <= m; i ++){
            dp[i][0] = true;
            for(int j = i; j <= m; j ++){
                for(int k = 1; k <= n; k ++){
                    if(t.charAt(k - 1) == '*'){
                        dp[j][k] = dp[j][k - 1] || ( j > i && dp[j - 1][k]);
                    }else{
                        dp[j][k] = j > i && dp[j - 1][k - 1] && s.charAt(j -1) == t.charAt(k - 1);
                    }
                }
                if(dp[j][n] && j - i != 0 && j - i < m - i){
                    flag = false;
                    System.out.println(i + " " + (j - i));
                }
            }
        }
        if(flag)
            System.out.println("-1 0");
    }
}
