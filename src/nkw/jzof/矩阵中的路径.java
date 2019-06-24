package nkw.jzof;

/**
 * @author: fangcong
 * @date: 2019/6/24
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        String matrix = "ABCESFCSADEE";
        String str = "ABCCED";
        boolean res = hasPath(matrix.toCharArray(),3, 4, str.toCharArray());
        System.out.println(res);
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] isVisited = new boolean[matrix.length];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(helper(matrix, rows, cols, i, j, str, 0, isVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean helper(char[] matrix,int rows, int cols, int i, int j, char[] str, int len, boolean[] isVisited){
        if(len == str.length)
            return true;
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[len] || isVisited[index])
            return false;
        isVisited[index] = true;
        if(helper(matrix, rows, cols, i - 1, j, str, len + 1, isVisited)
            || helper(matrix, rows, cols, i, j + 1, str, len + 1, isVisited)
            || helper(matrix, rows, cols, i + 1, j , str ,len + 1, isVisited)
            || helper(matrix, rows, cols, i, j - 1, str, len + 1, isVisited))
            return true;
        isVisited[index] = false;
        return false;
    }
}
