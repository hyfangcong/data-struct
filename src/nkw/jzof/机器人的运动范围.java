package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */
public class 机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return helper(threshold, rows, cols, 0, 0, flag, 0);
    }

    private int helper(int threshold, int rows, int cols, int i, int j, int[][] flag, int step) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] == 1 || numSum(i) + numSum(j) > threshold)
            return 0;

        flag[i][j] = 1;
        return helper(threshold, rows, cols, i, j - 1, flag, step + 1) +
                helper(threshold, rows, cols, i, j + 1, flag, step + 1) +
                helper(threshold, rows, cols, i - 1, j, flag, step + 1) +
                helper(threshold, rows, cols, i + 1, j, flag, step + 1) + 1;


    }

    private int numSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }

}
