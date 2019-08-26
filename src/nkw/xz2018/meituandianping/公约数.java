package nkw.xz2018.meituandianping;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: fangcong
 * @date: 2019/8/15
 */
public class 公约数 {
    static int ans = 0;
    static int A;
    static int B;
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> tmp = new ArrayList<>();
    public static void process(int[] arr, int k, int index){
        if(tmp.size() == k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index; i < arr.length; i++){
            tmp.add(arr[i]);
            process(arr, k, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static int gcd(int x, int y){
        while(x * y != 0){
            if(x > y){
                x %= y;
            }else{
                y %= x;
            }
        }
        return x > y ? x : y;
    }


    /**
     * 动态规划 dp[j][k]:在[0,i]上选择j个数，他们的乘积和A的最大公约数为k
     *
     * 地推关系式：dp[j+1][k] += dp[j][gcd(k*arr[i],a)] ( 0<= j <= i)
     *            dp[0][gcd(k*arr[i],a)] += 1;
     *
     *
     */
    public static void solution(int arr[], int K){
        int n = arr.length;
        long[][] dp = new long[n][100005];
        dp[0][gcd(arr[0], A)] = 1;
        for(int i = 1; i < n ; i++){
            for(int j = i-1; j >= 0; j --){
                for(int k = A; k > 0 ; k--){
                    if(dp[j][k] != 0){
                        dp[j+1][gcd(arr[i]*k, A)] += dp[j][k];
                    }
                }
            }

            dp[0][gcd(arr[i], A)] += 1;
        }

        long ans = 0;
        for(int i = B; i <= A; i++){
            ans += dp[K-1][i];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        solution(arr, k);
    }
}
