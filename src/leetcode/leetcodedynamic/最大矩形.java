package leetcode.leetcodedynamic;

public class 最大矩形 {
    /**
     * 将二维降维到一维
     */

    public static int maximalRectangle(String[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m; i ++){
            for(int j = n - 1; j >= 0 ; j--){
                if(matrix[i][j] == "1")
                    dp[i][j] = j + 1 < n ? dp[i][j + 1] + 1 : 1;
            }
        }

        //利用dp数组构造单调栈

        int res = 0;
        for (int col = n - 1; col >= 0; col--) {
            for (int beginRow = 0; beginRow < m; beginRow++) {
               int tmp = dp[beginRow][col];
               for(int endRow = beginRow; endRow < m && dp[endRow][col] != 0; ){
                   tmp = tmp < dp[endRow][col] ? tmp : dp[endRow][col];
                   while(endRow < m && dp[endRow][col] >= tmp)
                       endRow++;

                   int area = tmp * (endRow - beginRow);
                   res = res > area ? res : area;
               }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[][] martrix = new String[][]{
                {"1","1","1","1","1","1","1","1"},
                {"1","1","1","1","1","1","1","0"},
                {"1","1","1","1","1","1","1","0"},
                {"1","1","1","1","1","0","0","0"},
                {"0","1","1","1","1","0","0","0"}};

        int res = maximalRectangle(martrix);
        System.out.println(res);
    }
}
