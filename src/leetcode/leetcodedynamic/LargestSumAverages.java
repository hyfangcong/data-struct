package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/17
 */
public class LargestSumAverages {
    public static void main(String[] args) {
        LargestSumAverages tt = new LargestSumAverages();
        int[] a = {1,2,3,4,5,6,7};
        System.out.println(tt.largestSumOfAverages(a, 4));
    }

    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[][] memo = new double[N+1][N+1];
        double cur = 0;
        for (int i = 0; i < N; ++i) {
            cur += A[i];
            memo[i + 1][1] = cur / (i + 1);
        }
        return search(N, K, A, memo);
    }

    public double search(int n, int k, int[] A, double[][] memo) {
        if (memo[n][k] > 0) return memo[n][k];
        if (n < k) return 0;
        double cur = 0;
        for (int i = n - 1; i > 0; --i) {
            cur += A[i];
            memo[n][k] = Math.max(memo[n][k], search(i, k - 1, A, memo) + cur / (n - i));
        }
        return memo[n][k];
    }
}
