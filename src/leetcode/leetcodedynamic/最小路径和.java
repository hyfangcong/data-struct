package leetcode.leetcodedynamic;

public class 最小路径和 {

    private static int[][] memo;
    private static int tryMinSum(int row, int col , int[][] grid){
        if(memo[row][col] != 0)
            return memo[row][col];

        int res;
        if(row - 1 >= 0 && col - 1 >= 0){
            res = memo[row][col] =  Math.min(tryMinSum(row - 1, col , grid), tryMinSum(row , col - 1 , grid)) + grid[row][col];
        }else if(row - 1 >= 0){
            res = memo[row][col] = tryMinSum(row - 1, col, grid) + grid[row][col];
        }else if(col - 1 >= 0){
            res = memo[row][col] = tryMinSum(row, col - 1, grid) + grid[row][col];
        }else
            res = grid[row][col];

        memo[row][col] = res ;
        return res;
    }
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        memo = new int[row][col];
        return tryMinSum(row - 1, col -1  , grid);
    }

    public static int minPathSum2(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] memory = new int[row][col];
        for(int i = 0 ; i < row ; i ++){
            for (int j = 0 ; j < col ; j ++){
                if(i - 1 >= 0 && j - 1 >= 0)
                    memory[i][j] = Math.min(memory[i - 1][j], memory[i][j - 1]) + grid[i][j];
                else if(i - 1 >= 0)
                    memory[i][j] = memory[i - 1][j] + grid[i][j];
                else if(j - 1 >= 0)
                    memory[i][j] = memory[i][j - 1] + grid[i][j];
                else
                    memory[i][j] = grid[i][j];
            }
        }
        return memory[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }
}
