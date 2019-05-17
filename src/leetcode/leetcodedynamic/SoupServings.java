package leetcode.leetcodedynamic;

/**
 * @author: fangcong
 * @date: 2019/5/17
 */
public class SoupServings {
    /**
     * 数据可以等比例缩小。节约空间
     */
    public double soupServings(int N) {
        int[][] operations = {{4,0}, {3, 1}, {2,2}, {1, 3}};
        double[][] memo = new double[200][200];
        return N > 4700 ? 1.0 : helper((N + 24) / 25, (N + 24) / 25,  operations, memo);
    }

    /**
     * 记忆化搜索
     */
    private double helper(int a, int b,int[][] operations, double[][] memo){
        if(a <= 0 && b <= 0)
            return 0.5;
        if(a <= 0 && b > 0)
            return 1;
        if(b <= 0)
            return 0;
        if(memo[a][b] > 0)
            return memo[a][b];
        double sum = 0;
        for(int[] operation : operations) {
            sum += helper(a - operation[0], b - operation[1], operations, memo);
        }
        return memo[a][b] = sum * 0.25;
    }
}
