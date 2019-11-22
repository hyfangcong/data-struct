package qz2019.vivo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fangcong
 * @date: 2019/9/11
 */
public class 消消乐 {
    public static void main(String[] args) {
        int[] input = {1,4,2,2,3,3,4,2,2,1};
        System.out.println(solution(input));
    }

    private static int solution(int[] input) {
        int n = input.length;
        int[][] dp = new int[n][n];
        for(int j = 0 ; j < n; j ++){
            dp[j][j] = 1;
            for(int i = 0; i < j; i++){
                int t = i+1;
                while(t <= j){
                    if(input[i] != input[t])
                        break;
                    t++;
                }
                int len1 = t-i;
                int left = t;
                t = j-1;
                while(t >= i){
                    if(input[t] != input[j])
                        break;
                    t--;
                }
                int len2 = j-t;
                int right = t;
                if(len1 + len2 >= j-i+1){
                    dp[i][j] = (j-i+1) * (j-i+1);
                }else{
                    dp[i][j] = Math.max(dp[i][j], dp[left][j] + len1*len1);
                    dp[i][j] = Math.max(dp[i][j], dp[i][right] + len2*len2);
                    dp[i][j] = Math.max(dp[i][j], dp[left][right] + len1*len1 + len2*len2);
                    if(input[i] == input[j]){
                        dp[i][j] = Math.max(dp[i][j], dp[left][right] + (len1+len2) * (len1+len2));
                    }
                }
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[0][n-1];
    }
}
