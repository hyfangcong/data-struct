package nkw.xz2018.jingdong;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/7/12
 */
public class 神奇数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int count = 0;
        for(int i = left; i <= right ; i++){
            if(isMagic(i))
                count++;
        }
        System.out.println(count);
    }

    public static boolean isMagic(int n){
        String s = n + "";
        int[] num = new int[s.length()];
        int sum = 0;
        for(int i = 0; i < num.length; i ++){
            int x = s.charAt(i) - '0';
            sum += x;
            num[i] = x;

        }
        if(sum % 2 != 0)
            return false;
        else{
            int mid = sum / 2;
            boolean[] dp = new boolean[mid + 1];
            dp[0] = true;
            for(int i = 0 ; i < num.length; i ++){
                for(int j = mid ; j >= 0 ; j --){
                    if(j >= num[i]){
                        dp[j] = dp[j] || dp[j - num[i]];
                    }
                }
            }
            return dp[mid];
        }
    }
}
