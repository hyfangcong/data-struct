package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/18
 */
public class New21Game {
    public static void main(String[] args) {
        New21Game tt = new New21Game();
       double res = tt.new21Game(12,2,10);
        System.out.println(res);
    }

    public double new21Game(int N, int K, int W) {
        double[][] memo = new double[N + 1][K + 1];
        double res = helper(N, K, W, memo);
        return res;
    }

    private double helper(int n, int k, int w, double[][] memo){
        if(k <= 0)
            return n >= 0 ? 1 : 0;

        if(memo[n][k] != 0)
            return memo[n][k];
        int sum = 0;
        for(int i =1 ; i <= w ; i++){
            sum += helper(n - i, k - i, w, memo) + 1;
        }
        return memo[n][k] = 1.0 / w * sum;
    }
}
