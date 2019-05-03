package leetcode.leetcode2018.array;

public class 搜索二维矩阵 {
    public static void main(String[] args) {
        int [][] martix = new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        (new 搜索二维矩阵()).searchMatrix(martix, 5);
    }

    /**
     * 主要是利用二维矩阵每行、每列各自升序的特性，选择合适的切入点
     *
     * 显然，左上角和右下角不合适，右上角和左下角可以
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix != null && matrix.length != 0){
            int row = matrix.length -1;
            int col = 0;
            while(col < matrix[0].length && row >= 0){
                if(matrix[row][col] > target){
                    row --;
                }else if(matrix[row][col] < target)
                    col ++;
                else
                    continue;
                    return true;
            }
        }
        return false;
    }
}
