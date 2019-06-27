package nkw.xz2018.aiqiyi;

import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/6/27
 */
public class 红和绿 {
    public static void main(String[] args) {
       solution4();
    }

    /**
     * 通过率50%
     */
    public static void solution1(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == 'R')
            left++;
        while (left <= right && s.charAt(right) == 'G')
            right--;
        int sumR = 0, sumG = 0;
        for(int i = left; i <= right; i ++){
            if(s.charAt(i) == 'G')
                sumG++;
            else
                sumR++;
        }
        int res = Math.min(sumG, sumR);
        System.out.println(res);
    }

    public static void solution2(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int sum = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'G')
                sum++;
        }
        res = sum;
        sum=0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == 'R')
                sum++;
        }
        res = Math.min(res, sum);
        System.out.println(res);
    }
//
//    /**
//     * 动态规划
//     *
//     */
//    public static void solution3(){
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        int n = s.length();
//        int[][] dp = new int[n + 1][2];
//        for(int i = 1; i <= n; i ++){
//           if(s.charAt(i) == 'G'){
//               dp[i][0] = Math.min(dp[i - 1][0], dp[i]
//           }
//        }
//    }

    /**
     * 只需要遍历一次数组,
     * 在当前位置为R时有可能两种情况,一种是吧这个位置变成G,另一种是吧前面的G全部变成R.
     */
    public static void solution4(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        int gCount = 0; //序列中'G'的个数
        int count = 0; //最小涂色数
        for(int i = 0; i < n; i ++){
            if(s.charAt(i) == 'G')
                gCount++;
            else{
                count = Math.min(gCount, count + 1);
            }
        }
        System.out.println(count);
    }
}
