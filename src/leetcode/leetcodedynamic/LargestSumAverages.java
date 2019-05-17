package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/17
 */
public class LargestSumAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] sums = new int[n + 1];
        for(int i = 0 ; i < n ; i ++){
            sums[i + 1] = sums[i] + A[i];
        }
        double max = 0.0;
        for(int i = 1 ; i < n - 1; i ++) {
            for(int j = i ; j < n - 1; j ++){
                double avg1 = (sums[i] - sums[0]) / i;
                double avg2 = (sums[j + 1] - sums[i]) / (j - i + 1);
                double avg3 = (sums[n] - sums[j + 1]) / (n - j);
                max = Math.max(max, avg1 + avg2 +avg3);
            }
        }
        return max;
    }
}
