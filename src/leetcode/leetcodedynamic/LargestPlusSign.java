package leetcode.leetcodedynamic;

import java.util.Arrays;

/**
 * @author: fangcong
 * @date: 2019/5/16
 */
public class LargestPlusSign {

    public static void main(String[] args) {
        LargestPlusSign tt = new LargestPlusSign();
        int[][] mines = {{1,2},{1,8},{2,4},{4,7},{5,0},{5,6},{6,4},{6,9}};
        int N = 10;
        System.out.println(tt.orderOfLargestPlusSign(N, mines));
    }
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int[] a : grid){
            Arrays.fill(a, 1);
        }
        for(int[] mine : mines){
            grid[mine[0]][mine[1]] = 0;
        }
        int max = 0;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0; j < N ; j++){
                int k = helper(i, j, grid);
                max = Math.max(max, k);
            }
        }
        return max;
    }

    private int helper(int i, int j, int[][] grid){
        int n = grid.length;
        int k = 0;
        if(grid[i][j] == 1){
            k++;
            while(i - k >= 0 && i + k < n &&j - k >= 0 && j + k < n){
                if(grid[i][j - k] == 1 && grid[i][j + k] == 1 && grid[i -k][j] == 1 && grid[i + k][j] == 1)
                    k++;
                else
                    break;
            }
        }
        return k;
    }
}
